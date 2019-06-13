package rs.ac.bg.etf.pp1;
import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;


public class SemanticAnalyzer extends VisitorAdaptor {

	public static final String MAIN_METHOD_NAME = "main";
	boolean errorDetected = false;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	int printCallCount = 0;


	private static Obj findCurrentScope(String name){
		return Tab.currentScope.findSymbol(name);
	}

	private static boolean existsInCurrentScope(String name){
		return findCurrentScope(name) != null;
	}

	/**
	 * Returns true if the obj is kind of Element or Var
	 *
	 *
	 * @param obj
	 * @return
	 */
	private static boolean isElemOrVar(Obj obj){
		return obj.getKind() == Obj.Elem || obj.getKind() == Obj.Var;
	}

	/**
	 * Returns true if the object is type of integer
	 *
	 *
	 * @param obj
	 * @return
	 */
	private static boolean isInteger(Obj obj){
		return obj.getType() == Tab.intType;
	}

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}

	final Struct boolType = new Struct(Struct.Bool);
	public SemanticAnalyzer() {
 		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

	public boolean passed() {
		return !errorDetected;
	}

	@Override
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();

		Obj mainMethod = Tab.find(MAIN_METHOD_NAME);

		// main metoda
		if(
			mainMethod != null && // postoji
			mainMethod.getType() == Tab.noType && // nema povratni tip
			mainMethod.getFpPos() == 0 // nema argumente
		){
			Tab.chainLocalSymbols(program.getProgramName().obj); // import symbols to program name
			Tab.closeScope(); // close program scope
		}
		else if(mainMethod == null){
			report_error("Main method ne postoji!", program);
		}
		else{
			if(mainMethod.getType() != Tab.noType)
				report_error("Main method ne sme da ima povratni tip!", program);
			if(mainMethod.getFpPos() > 0)
				report_error("Main method ne sme da ima argumente!", program);
		}
	}

	@Override
	public void visit(ProgramName programName){
		Obj pName = Tab.currentScope().findSymbol(programName.getPName());

		if(pName != null) {
			report_error(programName.getPName() + " vec postoji u trenutnom opsegu", programName);
			programName.obj = new Obj(Obj.Prog, programName.getPName(), Tab.noType);
		}
		else {
			programName.obj = Tab.insert(Obj.Prog, programName.getPName(), Tab.noType);
		}
		Tab.openScope(); // open program scope
	}

	public void visit(MethodTypeDeclarating methodTypeDeclarating){
		Object typedMethod = Tab.currentScope.findSymbol(methodTypeDeclarating.getMName());


		if(typedMethod != null){
			report_error("Metoda " + methodTypeDeclarating.getMName() + " je vec definisana u trenutno opsegu", methodTypeDeclarating);
			currentMethod = new Obj(Obj.Meth, methodTypeDeclarating.getMName(), lastType);
		}
		else // metoda nije definisana u trenutnom opsegu
			currentMethod = Tab.insert(Obj.Meth, methodTypeDeclarating.getMName(), lastType);

		// obj metode set
		methodTypeDeclarating.obj = currentMethod;
		Tab.openScope(); // open method scope
	}

	@Override
	public void visit(MethodVoidDeclarating methodVoidDeclarating){
		Obj symbol = Tab.currentScope.findSymbol(methodVoidDeclarating.getMName());

		if(symbol != null){
			report_error("Metoda " + methodVoidDeclarating.getMName() + " je vec definisana u trenutno opsegu", methodVoidDeclarating);
			currentMethod = new Obj(Obj.Meth, methodVoidDeclarating.getMName(), Tab.noType);
		}
		else // metoda nije definisana u trenutnom opsegu
			currentMethod = Tab.insert(Obj.Meth, methodVoidDeclarating.getMName(), Tab.noType);

		// obj metode set
		methodVoidDeclarating.obj = currentMethod;
		Tab.openScope(); // open method scope
	}

	@Override
	public void visit(MethodParamDeclaring methodParams){
		Scope scope = Tab.currentScope;
		String name  = methodParams.getPName();
		if(existsInCurrentScope(methodParams.getPName())){
			report_error("Identifikator " + methodParams.getPName() + " je vec definisan u metodi!", methodParams);
		}
		// doesnt exists
		else{
			// if it is array
			if(methodParams.getArrayDeclaresOptional() instanceof  ArrayDeclaringOptionalValue){
				// insert array into local scope chain
				Tab.insert(Obj.Var, methodParams.getPName(), new Struct(Struct.Array, lastType));
			}
			else{
				// insert variable into chain
				Tab.insert(Obj.Var, methodParams.getPName(), lastType);
			}
		}
	}


	@Override
	public void visit(MethodDeclarating methodDeclaration){
		if(returnFound){
			report_error("Main metoda mora biti type void!", methodDeclaration);
		}

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		returnFound = false;
		currentMethod = null;
	}


	/**
	 * Enum declarating
	 */
	private int enumValue; // enum value counter

	@Override
	public void visit(EnumName enumName){
		Obj objEnumName = Tab.currentScope.findSymbol(enumName.getEName());

		if(objEnumName != null)
		{
			report_error("Enum: " + enumName.getEName() + " vec postoji u trenutnom opsegu", enumName);
			enumName.obj = new Obj(Obj.Type, enumName.getEName(), new Struct(Struct.Enum));
		}
		else
			enumName.obj = Tab.insert(Obj.Type, enumName.getEName(), new Struct(Struct.Enum));

		Tab.openScope();
		enumValue = 0;
	}

	@Override
	public void visit(EnumDeclarating enumDeclarating){
		// insert enum type into local
		Tab.chainLocalSymbols(enumDeclarating.getEnumName().obj.getType());
		Tab.closeScope();
	}


	@Override
	public void visit(EnumDeclaringValue enumDeclaringValue){
		enumValue = enumDeclaringValue.getCNum();
		Obj objectEnumName = Tab.currentScope.findSymbol(enumDeclaringValue.getCName());
		Obj constObj;

		if(objectEnumName != null) // name exists
		{
			report_error("Enum polje imena: " + enumDeclaringValue.getCName() + " je vec definisano", enumDeclaringValue);
			constObj = new Obj(Obj.Con, enumDeclaringValue.getCName(), Tab.intType);
		}
		else
		{
			constObj = Tab.insert(Obj.Con, enumDeclaringValue.getCName(), Tab.intType);
		}


		constObj.setAdr(enumValue);
		enumValue++; // increment enum value
	}

	@Override
	public void visit(EnumDeclaringNoValue enumDeclaringNoValue){
		Obj objectEnumName = Tab.currentScope.findSymbol(enumDeclaringNoValue.getCName());
		Obj constObj;

		if(objectEnumName != null) // name exists
		{
			report_error("Enum polje: " + enumDeclaringNoValue.getCName() + " je vec definisano", enumDeclaringNoValue);
			constObj = new Obj(Obj.Con, enumDeclaringNoValue.getCName(), Tab.intType);
		}
		else
		{
			constObj = Tab.insert(Obj.Con, enumDeclaringNoValue.getCName(), Tab.intType);
			constObj.setAdr(enumValue);
		}
		enumValue++; // increment enum value
	}


	// Last type that is visited
	Struct lastType = null;

	@Override
	public void visit(Type type){
		Obj typeObject = Tab.find(type.getTypeName());

		if (typeObject != Tab.noObj) {
			if (typeObject.getKind() == Obj.Type) {
				type.struct = typeObject.getType();
			} else {
				report_error("Greska : " + type.getTypeName() + " nije tip! ", type);
				type.struct = Tab.noType;
			}
		} else {
			report_error("Greska : " + type.getTypeName() + " ne postoji u tabeli simbola", type);
			type.struct = Tab.noType;
		}
		lastType = type.struct;
	}

	@Override
	public void visit(NumConst numConst) {
		Obj objNumConst = findCurrentScope(numConst.getVName());

		if (objNumConst == null) // doesnt exists
		{
			Obj newNumConst = Tab.insert(Obj.Con, numConst.getVName(), numConst.getType().struct);
			newNumConst.setAdr(numConst.getCNum());
		} else {
			report_error("Greska: Identifikator `" + numConst.getVName() + "` je vec deklarisana!", numConst);
		}
		// NumConst must be int type
		if (numConst.getType().struct != Tab.intType) {
			report_error("Greska: Identifikator `" + numConst.getVName() + "` mora biti celobrojna vrednost(int)!", numConst);
		}
	}

	@Override
	public void visit(CharConst charConst) {
		Obj objNumConst = findCurrentScope(charConst.getVName());

		if (objNumConst == null) // doesnt exists
		{
			Obj newNumConst = Tab.insert(Obj.Con, charConst.getVName(), charConst.getType().struct);
			newNumConst.setAdr(charConst.getCChar());
		} else {
			report_error("Greska: Identifikator `" + charConst.getVName() + "` je vec deklarisana!", charConst);
		}
		// NumConst must be int type
		if (charConst.getType().struct != Tab.charType) {
			report_error("Greska: Identifikator `" + charConst.getVName() + "` mora biti odgovarajuca vrednost!", charConst);
		}
	}


	@Override
	public void visit(BoolConst boolConst){
		Obj objNumConst = findCurrentScope(boolConst.getVName());

		if (objNumConst == null) // doesnt exists
		{
			Obj newNumConst = Tab.insert(Obj.Con, boolConst.getVName(), boolConst.getType().struct);
			newNumConst.setAdr(boolConst.getCBool() ? 1 : 0);
		} else {
			report_error("Greska: Identifikator `" + boolConst.getVName() + "` je vec deklarisana!", boolConst);
		}
		// NumConst must be int type
		if (boolConst.getType().struct != boolType) {
			report_error("Greska: Identifikator `" + boolConst.getVName() + "` mora biti odgovarajuca vrednost!", boolConst);
		}
	}


	@Override
	public void visit(VarMember varMember){
		if(findCurrentScope(varMember.getVName()) == null) // promenljiva ne postoji
		{
			Tab.insert(Obj.Var, varMember.getVName(), lastType);
		}
		else
		{
			report_error("Greska: Identifikator " + varMember.getVName() + " je vec deklarisan!", varMember);
		}
	}

	public void visit(VarArray varArray){
		if(existsInCurrentScope(varArray.getVName())) // postoji identifikator sa ovim imenom
		{
			report_error("Greska Identfikator " + varArray.getVName() + " vec postoji!", varArray);
		}
		else
		{
			Tab.insert(Obj.Var, varArray.getVName(), new Struct(Struct.Array, lastType));
		}
	}

	public void visit(VarDeclaratingError varDeclaratingError){
		if(currentMethod == null){
			report_error("Oporavak od sintaksne greske, preskacemo sve do ';' prilikom globalne promenljive", varDeclaratingError);
		}
		else
			report_error("Oporavak od sintaksne greske, preskacemo sve do ';' prilikom lokalne promenljive", varDeclaratingError);
	}

	@Override
	public void visit(VarDeclListError1 varError){
		if(currentMethod==null) report_error("Oporavak od sintaksne greske posle ',' prilikom definisanja globalnih promenljivih!", varError);
		else report_error("Oporavak od sintaksne greske posle ',' prilikom definisanja lokalnih promenljivih!", varError);
	}

	@Override
	public void visit(VarDeclListError2 varError){
		if(currentMethod==null) report_error("Oporavak od sintaksne greske pre ',' prilikom definisanja globalnih promenljivih!", varError);
		else report_error("Oporavak od sintaksne greske pre ',' prilikom definisanja lokalnih promenljivih!", varError);
	}

	@Override
	public void visit(DesignatorAssignExprError designatorError){
		report_error("Oporavak od sintaksne greske sve do ';', prilikom dodele vrednosti!", designatorError);
	}

	@Override
	public void visit(StatementPrint statementPrint){
		if( !statementPrint.getExpression().struct.equals(Tab.intType) &&
			!statementPrint.getExpression().struct.equals(Tab.charType) &&
			!statementPrint.getExpression().struct.equals(boolType))
			report_error("print funkcija je primenljiva samo na osnovnim tipovima", statementPrint);
	}

	@Override
	public void visit(StatementRead statementRead){
		if(
			!(
			statementRead.getDesignator().obj.getKind() == Obj.Elem ||
			statementRead.getDesignator().obj.getKind() ==  Obj.Var
			)
		){
			report_error("Read funkcija prima argument `" + statementRead.getDesignator().obj.getName() +  " tipa promenljive ili elementa niza", statementRead);
		}

		if( !statementRead.getDesignator().obj.getType().equals(Tab.intType) &&
				!statementRead.getDesignator().obj.getType().equals(Tab.charType) &&
				!statementRead.getDesignator().obj.getType().equals(boolType))
			report_error("read funkcija je primenljiva samo na osnovnim tipovima", statementRead);
	}


	@Override
	public void visit(TermMulListMember termMulListMember){
		Struct factorStruct = termMulListMember.getFactor().struct;
		Struct termStruct = termMulListMember.getTerm().struct;

		if( // if it is int type or member of an enum
			(factorStruct == Tab.intType || factorStruct.getKind() == Struct.Enum ) &&
			(termStruct == Tab.intType || termStruct.getKind() == Struct.Enum )
		)
		{
			// struct is tab int type
			termMulListMember.struct = Tab.intType;
		}
		else
		{
			report_error("Greska nekompatibilni tipovi u izrazu!", termMulListMember);
			termMulListMember.struct = Tab.noType;
		}
	}

	@Override
	public void visit(ExpressionAddTermListMember expressionAddTermListMember){
		Struct exprStruct = expressionAddTermListMember.getExpressionAddTermList().struct;
		Struct termStruct = expressionAddTermListMember.getTerm().struct;

		if( (exprStruct == Tab.intType || exprStruct.getKind() == Struct.Enum) &&
			(termStruct == Tab.intType || termStruct.getKind() == Struct.Enum))
		{
			expressionAddTermListMember.struct = Tab.intType;
		}
		else
		{
			report_error("Greska nekompatibilni tipovi u izrazu!", expressionAddTermListMember);
			expressionAddTermListMember.struct = Tab.noType;
		}
	}

	@Override
	public void visit(ExpressionAddTermEpsilon expressionAddTermEpsilon){
		// propagate type
		expressionAddTermEpsilon.struct = expressionAddTermEpsilon.getTerm().struct;
	}


	@Override
	public void visit(TermMulEpsion termMulEpsion){
		// propagate type to parent in tree
		termMulEpsion.struct = termMulEpsion.getFactor().struct;
	}

	@Override
	public void visit(FactorDesignating factorDesignating) {
		factorDesignating.struct = factorDesignating.getDesignator().obj.getType();
	}

	@Override
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType; // set int type
	}

	@Override
	public void visit(FactorChar factorChar) {
		// set char type
		factorChar.struct = Tab.charType;
	}

	@Override
	public void visit(FactorBool factorBool) {
		// set bool type
		factorBool.struct = boolType;
	}


	@Override
	public void visit(FactorExpression factorExpression) {
		// propagate type
		factorExpression.struct = factorExpression.getExpression().struct;
	}

	@Override
	public void visit(FactorExpressOptionalNoValue factorExpressOptionalNoValue) {
		factorExpressOptionalNoValue.struct = Tab.noType; // set no type
	}

	@Override
	public void visit(FactorExpressOptionalValue factorExpressOptionalValue) {
		factorExpressOptionalValue.struct = factorExpressOptionalValue.getExpression().struct;
	}

	@Override
	public void visit(FactorNew factorNew) {
		// between squares must be int or enum constant
		if(factorNew.getFactorExpressionOptional().struct != Tab.intType &&
			factorNew.getFactorExpressionOptional().struct.getKind() != Struct.Enum){
			report_error("Velicina niza mora biti celobrojna vrednost!", factorNew);
		}
		factorNew.struct = new Struct(Struct.Array, lastType);
	}

	@Override
	public void visit(Expression expression) {
		if(
			(expression.getMinusOptional() instanceof MinusOptionalValue) &&
			!(expression.getExpressionAddTermList().struct == Tab.intType || expression.getExpressionAddTermList().struct.getKind() == Struct.Enum)
		){
			report_error("Pogresan izraz, kada koristite minus u izrazu morate odraditi imati celobrojnu vrednost!", expression);
		}

		// propagate type
		expression.struct = expression.getExpressionAddTermList().struct;
	}

	@Override
	public void visit(DesignatorIncrementing designatorIncrementing) {
		if(!isElemOrVar(designatorIncrementing.getDesignator().obj))
			report_error("Simbol mora biti element niza ili promenljiva!", designatorIncrementing);

		if(!isInteger(designatorIncrementing.getDesignator().obj))
			report_error("Simbol mora biti celobrojna vrendnost", designatorIncrementing);
	}

	@Override
	public void visit(DesignatorDecrementing designator) {
		if(!isElemOrVar(designator.getDesignator().obj))
			report_error("Simbol mora biti element niza ili promenljiva!", designator);

		if(!isInteger(designator.getDesignator().obj))
			report_error("Simbol mora biti celobrojna vrendnost", designator);
	}

	@Override
	public void visit(DesignatorAssignExpression designatorAssignExpression) {
		// object to which we are assigning to
		if(!isElemOrVar(designatorAssignExpression.getDesignator().obj))
			report_error("Simbol mora biti element niza ili promenljiva", designatorAssignExpression);



		Obj designatorObject = designatorAssignExpression.getDesignator().obj;
		Struct expressionType = designatorAssignExpression.getExpression().struct;

		// fix for int matija = Broj; // enum Broj{JEDAN, DVA, TRI} // todo
		if(expressionType.getKind() == Obj.Prog)
			report_error("Simbol koji dodeljujemo ne sme biti tip!", designatorAssignExpression);


		if(!expressionType.assignableTo(designatorObject.getType()) &&
			!(
					(expressionType.equals(Tab.intType) && designatorObject.getType().getKind() == Struct.Enum)	// cant assign enum to int
					||
					(expressionType.getKind() == Struct.Enum && designatorObject.getType() == Tab.intType) // cant assign int to enum
			)
		){
			report_error("Tipovi nisu kompatibilni za dodelu vrednosti!", designatorAssignExpression);
		}
	}

	@Override
	public void visit(DesignatorDeclaration designatorDeclaration) {
		designatorDeclaration.obj = Tab.find(designatorDeclaration.getDName());

		// there is not globaly founded ident
		if(designatorDeclaration.obj == Tab.noObj){
			report_error("Identifikator `" + designatorDeclaration.getDName() +"` nije deklarisan!", designatorDeclaration);
		}
		else // designator founded
		{
			DumpSymbolTableVisitor visitor = new DumpSymbolTableVisitor();
			visitor.visitObjNode(designatorDeclaration.obj);

			// is variable
			if(designatorDeclaration.obj.getKind() == Obj.Var){
				if(designatorDeclaration.obj.getLevel() == 0){
					report_info("Koristi se globalna promenljiva " + visitor.getOutput(), designatorDeclaration);
				}
				else{
					report_info("Koristi se lokalna promenljiva " + visitor.getOutput(), designatorDeclaration);
				}
			}
			else if(designatorDeclaration.obj.getKind() == Obj.Con){
				report_info("Koristi se konstanta "+ visitor.getOutput(), designatorDeclaration);
			}
		}
	}

	@Override
	public void visit(DesignatorArray designatorArray) {
		Obj arrayType = Tab.find(designatorArray.getArrayDesignator().getDesignator().obj.getName());
		designatorArray.obj = new Obj(Obj.Elem, "", arrayType.getType().getElemType());

		if(Struct.Array != arrayType.getType().getKind()){
			report_error("Tip simbola mora biti niz!", designatorArray);
			designatorArray.obj = Tab.noObj;
		}

		if(!(designatorArray.getExpression().struct == Tab.intType || designatorArray.getExpression().struct.getKind() == Struct.Enum)){
			report_error("Izraz izmedju zagrada mora biti celobrojna vrednost!", designatorArray);
			designatorArray.obj = Tab.noObj;
		}
		// to which index we are accessing
		report_info("Prostupamo clanu niza " + designatorArray.getArrayDesignator().getDesignator().obj.getName(), designatorArray);
	}

	@Override
	public void visit(DesignatorDot designator) {
		Obj accessObj = Tab.find(designator.getDName());

		if(Struct.Enum != accessObj.getType().getKind()){
			report_error("Objekat kome se pristupa mora biti enum!", designator);
		}

		designator.obj = accessObj.getType().getMembersTable().searchKey(designator.getRName());
		if(designator.obj == null){
			report_error("Polje `" + designator.getRName() + "` ne postoji u enumu", designator);
			designator.obj = Tab.noObj;
		}

		report_info("Pristupamo clanu enuma `" + designator.getDName() + "." + designator.getRName() + "` ", designator);
	}

//	@Override
//	public void visit(ExpressionOptionalValue expressionOptionalValue) {
//		report_error("Metoda ne vraca vrednost!" , expressionOptionalValue);
//	}
}

