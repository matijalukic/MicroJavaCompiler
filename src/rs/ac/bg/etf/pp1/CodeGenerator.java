package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}


	@Override
	public void visit(VarListElem varListElem) {
		varCount++;
	}




	private int statementPrintNumConst = 1;// width of the print

	@Override
	public void visit(StatementNumConstOptionalValue node) {
		statementPrintNumConst = node.getSNum();
	}

	@Override
	public void visit(StatementNumConstOptionNoValue node) {
		statementPrintNumConst = 1; // no constant print
	}

	@Override
	public void visit(StatementPrint statementPrint){
		Code.loadConst(statementPrintNumConst);
		// print char
		if(statementPrint.getExpression().struct.equals(Tab.charType))
		{
			// char type print
			Code.put(Code.bprint);
		}
		else // other one print
		{
			Code.put(Code.print);
		}
	}

	@Override
	public void visit(StatementRead statementRead) {
		// if its not char
		if(!statementRead.getDesignator().obj.getType().equals(Tab.charType))
		{
			Code.put(Code.read);
		}
		else // is char
		{
			Code.put(Code.bread);
		}
	}




	@Override
	public void visit(Expression node) {
		// todo minus
	}
	public void visit(MinusOptionalValue node){
		Code.put(Code.neg);
	}


	@Override
	public void visit(ExpressionAddTermListMember exprAddTermListMember) {
		if (exprAddTermListMember.getAddop() instanceof AddopMinus) {
			Code.put(Code.sub);
		} else {
			Code.put(Code.add);
		}
	}

//
//	@Override
//	public void visit(AddopPlus node) {
//		Code.put(Code.add);
//	}
//	@Override
//	public void visit(AddopMinus node) {
//		Code.put(Code.sub);
//	}


	@Override
	public void visit(TermMulListMember termMulListMember) {
		if (termMulListMember.getMulop() instanceof MulopMul) {
			Code.put(Code.mul);
		} else if (termMulListMember.getMulop() instanceof MulopDiv) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}


//	@Override
//	public void visit(MulopMul node) {
//		Code.put(Code.mul);
//	}
//	@Override
//	public void visit(MulopDiv node) {
//		Code.put(Code.div);
//	}
//	@Override
//	public void visit(MulopMod node) {
//		Code.put(Code.rem);
//	}


	@Override
	public void visit(FactorDesignating node) {
		// accessing the member
		if(node.getFactorActualParametersOptional() instanceof FactorActualParemeterOptionalNoValue){
			Code.load(node.getDesignator().obj);
		}
		// calling the method
		else {
		}
	}

	@Override
	public void visit(FactorNew node) {

		// allocating array
		if(node.getFactorExpressionOptional() instanceof FactorExpressOptionalValue){
			Code.put(Code.newarray);
			if(!node.getType().struct.equals(Tab.charType)){
				Code.put(1);
			}
			else{
				Code.put(0);
			}
		}
		// else za klase
	}

	@Override
	public void visit(FactorNum node) {
		Code.loadConst(node.getFNum());
	}
	@Override
	public void visit(FactorChar node ) {
		Code.loadConst(node.getFChar());
	}
	@Override
	public void visit(FactorBool node) {
		Code.loadConst(node.getFBool() ? 1 : 0);
	}


	// accessing to the array
	@Override
	public void visit(ArrayDesignator node) {
		Code.load(node.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorAssignExpression expr) {
		Code.store(expr.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorIncrementing node) {
		if(node.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);

		Code.load(node.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add); // add one instead of incrementing
		Code.store(node.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorDecrementing node) {
		if(node.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);

		Code.load(node.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub); // add one instead of incrementing
		Code.store(node.getDesignator().obj);

	}


	private static class MethodParamsCounter extends VisitorAdaptor{

		int parameterCounter = 0;

		@Override
		public void visit(MethodParamDeclaring methodTypeDeclarating) {
			parameterCounter++;
		}
	}


	@Override
	public void visit(MethodTypeDeclarating node) {
		// set the method address
		node.obj.setAdr(Code.pc);

		MethodParamsCounter methodParamsCounter = new MethodParamsCounter();
		node.getParent().traverseTopDown(methodParamsCounter);

		Code.put(Code.enter); // enter to the method
		Code.put(methodParamsCounter.parameterCounter); // broj argumenata
 		Code.put(node.obj.getLocalSymbols().size()); // broj argumenata + lokalnih promenljivih

	}

	@Override
	public void visit(MethodVoidDeclarating methodVoidDeclarating) {

		// set the main PC for the method void
		if("main".equals(methodVoidDeclarating.getMName())){
			mainPc = Code.pc;
		}
		methodVoidDeclarating.obj.setAdr(Code.pc); // set the program counter of the method

		MethodParamsCounter methodParamsCounter = new MethodParamsCounter();
		methodVoidDeclarating.getParent().traverseTopDown(methodParamsCounter);

		Code.put(Code.enter); // pocetak obrade metode
		Code.put(methodParamsCounter.parameterCounter); // number of params
		Code.put(methodVoidDeclarating.obj.getLocalSymbols().size()); // broj promenljivih metode + broj lokalnih


	}

//	@Override
//	public void visit(StatementReturn statementReturn) {
//		Code.put(Code.dup);
//		Code.put(Code.exit);
//		Code.put(Code.return_);
//	}

	@Override
	public void visit(MethodDeclarating methodDeclaration) {
		// returning value
		if(methodDeclaration.getMethodTypeDeclaration() instanceof MethodTypeDeclarating)
			Code.put(Code.dup);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}


	@Override
	public void visit(ActualParametersOptionalValue methodCall) {
		SyntaxNode methodDesignator;
		methodDesignator = methodCall.getParent();

		while(
			!(methodDesignator instanceof DesignatorActual)
			&&
			!(methodDesignator instanceof FactorDesignating) // indirect method calling
			&&
			methodDesignator != null
		){
			methodDesignator = methodDesignator.getParent();
		}



		Obj methodToCallObj;
		if(methodDesignator instanceof DesignatorActual)
			methodToCallObj = ((DesignatorActual) methodDesignator).getDesignator().obj;
		else
			methodToCallObj = ((FactorDesignating) methodDesignator).getDesignator().obj;

		int offset = methodToCallObj.getAdr() - Code.pc;


		Code.put(Code.call);
		Code.put2(offset);

		// if it is returning pop the return value
		if(!methodToCallObj.getType().equals(Tab.noType)){
			Code.put(Code.pop);
		}
	}

}
