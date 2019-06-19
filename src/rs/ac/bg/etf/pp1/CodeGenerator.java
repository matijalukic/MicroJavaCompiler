package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

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


	@Override
	public void visit(MethodVoidDeclarating methodVoidDeclarating) {

		// set the main PC for the method void
		if("main".equals(methodVoidDeclarating.getMName())){
			mainPc = Code.pc;
		}

		Code.put(Code.enter);
		Code.put(0);
		Code.put(methodVoidDeclarating.obj.getLocalSymbols().size()); // todo check why is + 0

		methodVoidDeclarating.obj.setAdr(mainPc);
	}


	@Override
	public void visit(MethodDeclarating methodDeclaration) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	private int statementPrintNumConst = 1;

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
			// todo calling the method
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
}
