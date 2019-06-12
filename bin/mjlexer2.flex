package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import org.apache.log4j.*;

// import java.io.*;
import rs.ac.bg.etf.pp1.ast.*;


parser code {:
	
	boolean errorDetected = false;
	
	Logger log = Logger.getLogger(getClass());
   
   
    // slede redefinisani metodi za prijavu gresaka radi izmene teksta poruke
     
    public void report_fatal_error(String message, Object info) throws java.lang.Exception {
      done_parsing();
      report_error(message, info);
    }
  
    public void syntax_error(Symbol cur_token) {
        report_error("\nSintaksna greska", cur_token);
    }
  
    public void unrecovered_syntax_error(Symbol cur_token) throws java.lang.Exception {
        report_fatal_error("Fatalna greska, parsiranje se ne moze nastaviti", cur_token);
    }

    public void report_error(String message, Object info) {
    	errorDetected = true;
    	StringBuilder msg = new StringBuilder(message); 
    	if (info instanceof Symbol)
            msg.append (" na liniji ").append(((Symbol)info).left);
        log.error(msg.toString());
    }
    
    public void report_info(String message, Object info) {
    	StringBuilder msg = new StringBuilder(message); 
    	if (info instanceof Symbol)
            msg.append (" na liniji ").append(((Symbol)info).left);
        log.info(msg.toString());
    }
    
:}

scan with {:
	Symbol s = this.getScanner().next_token();
	if (s != null && s.value != null) 
		log.info(s.toString() + " " + s.value.toString());
	return s;
:}


terminal PROG, PRINT, RETURN, VOID, CONST, CLASS, INTERFACE, ENUM, EXTENDS, IF, ELSE, FOR, BREAK, CONTINUE, NEW, IMPLEMENTS, DOT, AND, OR, PLUS, INCREMENT, MINUS, DECREMENT, MUL, DIV, MOD, EQUAL, IDENTICAL, NOTIDENTICAL, GREATER, GREATEREQ, LESS, LESSEQ, SEMI, COMMA, LPAREN, RPAREN, LBRACE, RBRACE, LSQUARE, RSQUARE;
terminal Integer NUMBER;
terminal String IDENT;
terminal Character CHARCONST;
terminal Boolean BOOLCONST;



nonterminal ProgramListVarDeclaration, ProgramMethodsList;
nonterminal FormalParamList, FormalParamDecl, FormPars, ActualPars, ActualParamList;
nonterminal VarDeclaration, ListVarDeclaration, VarDeclarationList, VarListElem; 
nonterminal StatementList, Statement, Addop;
nonterminal Unmatched, Matched, VarName, ConstDeclaration, ConstDeclValue;
nonterminal ConstDeclarationList, ConstDeclarationValue, Assignop;
nonterminal EnumDeclaration, EnumName, EnumValue, EnumDeclarationList;
nonterminal MethodDeclarationList;
nonterminal MethodParamsOptional, MethodParams, ArrayDeclaresOptional, MethodParamsList;
nonterminal DesigantorStatement, Condition, DesigantorStatementOptional, ConditionOptional, ExpressionOptional ;
nonterminal StatementNumConstOptional, ActivateParametersOptional, ActivateParameters;
nonterminal ActivateParametersExpressionList, ConditionTermList, ConditionTerm;
nonterminal ConditionFactRelopExpressionOptional, ConditionFactList, ExpressionAddTermList;
nonterminal FactorExpressionOptional, FactorActivateParametersOptional;
nonterminal Mulop, Relop, ArrayDesignator, StatementElseOptional;

nonterminal rs.etf.pp1.symboltable.concepts.Obj Program, ProgName, Designator, MethodDeclaration, MethodTypeDeclaration; 
nonterminal rs.etf.pp1.symboltable.concepts.Struct Type, Term, Expression, Factor, VarDeclList; 


Program ::= (Program) PROG IDENT:pName ProgramListVarDeclaration LBRACE MethodDeclarationList RBRACE
;


ProgramListVarDeclaration ::= 	
							(ProgramConstVarDeclarating) ProgramListVarDeclaration ConstDeclaration
							|
							(ProgramVarDeclarating) ProgramListVarDeclaration VarDeclaration			
							|
							(ProgramEnumDeclarating) ProgramListVarDeclaration EnumDeclaration
							|
							(NoProgramVarDeclarating)/* epsilon */
							;
						



ConstDeclaration ::= (ConstVarDeclarating) CONST ConstDeclarationValue SEMI
;

ConstDeclarationValue ::= (NumConst) Type IDENT:vName Assignop NUMBER:cNum
							|
							(CharConst) Type IDENT:vName Assignop CHARCONST:cChar
							|
							(BoolConst) Type IDENT:vName Assignop BOOLCONST:cBool
							;

ConstDeclarationList ::= (ConstDeclarationListMember) ConstDeclarationList COMMA IDENT:vName Assignop ConstDeclarationValue
							|
						(NoConstDeclaration)
							;

ListVarDeclaration ::= 
					(VarsDeclarating) ListVarDeclaration VarDeclaration
					|
					(VarsDeclaratingEpsilon)
					;


VarDeclaration ::=  
					(VarValidDeclaration) Type VarDeclarationList SEMI
					|
					(VarDeclaratingError) Type error SEMI
;
				
VarDeclarationList ::= 	
						(VarListSingle) VarListElem
						|
						(VarListMultiple) VarDeclarationList COMMA VarListElem
						|
						(VarDeclListError1) VarDeclarationList COMMA error
						|
						(VarDeclListError2) error COMMA VarListElem
						;

VarListElem ::= (VarMember) IDENT:vName
				|
				(VarArray) IDENT:vName LSQUARE RSQUARE
				;		

EnumDeclaration ::=
					(EnumDeclarating) ENUM EnumName LBRACE EnumValue EnumDeclarationList RBRACE
					;

EnumName ::= (EnumNaming) IDENT:eName
;

EnumValue ::= 
				(EnumDeclaringValue) IDENT:cName Assignop NUMBER:cNum
				|
				(EnumDeclaringNoValue) IDENT:cName
				;

EnumDeclarationList ::=
					(EnumDeclaratingListMember) EnumDeclarationList COMMA EnumValue
					|
					(NoEnumDeclaringList)
					;


MethodDeclarationList ::=
						(MethodDeclaratingList) MethodDeclarationList MethodDeclaration
						|
						(MethodDeclaratingEpsilon)
						;

MethodDeclaration ::= 
					(MethodDeclarating) MethodTypeDeclaration LPAREN MethodParamsOptional RPAREN ListVarDeclaration LBRACE StatementList RBRACE
					;

MethodTypeDeclaration ::= 
						(MethodTypeDeclarating) Type IDENT:mName
						|
						(MethodVoidDeclarating) VOID IDENT:mName
						;


MethodParamsOptional ::= 
						(MethodOptionalParamsDeclaring) MethodParams
						|
						(NoMethodParams)
						;

ArrayDeclaresOptional ::=
						(ArrayDeclaringOptionalValue) LSQUARE RSQUARE
						|
						(ArrayDeclaringOptionalNoValue)
						;

MethodParams ::= 
				(MethodParametersDeclaring) Type IDENT:fName ArrayDeclaresOptional MethodParamsList
				;
		

MethodParamsList ::= 
						(MethodParametersListing) MethodParamsList COMMA Type IDENT ArrayDeclaresOptional
						|
						(MethodParamsEpsilon)
						;

StatementList ::= (StatementListDeclaring) StatementList Statement
					|
					(StatementEpsilon)
					;

Statement ::= 
				(StatementDesignating) DesigantorStatement SEMI 
				|
				(StatementIf) IF LPAREN Condition RPAREN Statement StatementElseOptional
				|
				(StatementFor) FOR LPAREN DesigantorStatementOptional SEMI ConditionOptional SEMI DesigantorStatementOptional RPAREN Statement
				|
				(StatementBreaking) BREAK SEMI
				| 
				(StatementContinue) CONTINUE SEMI
				|
				(StatementReturn) RETURN ExpressionOptional SEMI
				|
				(StatementRead) READ LPAREN Designator RPAREN SEMI
				|
				(StatementPrint) PRINT LPAREN Expr StatementNumConstOptional RPAREN SEMI
				|
				(StatementBrace) LBRACE StatementList RPAREN
				;

StatementNumConstOptional ::=
								(StatementNumConstOptionalValue) COMMA NUMBER:sNum
								|
								(StatementNumConstOptionNoValue)
								;


DesigantorStatement ::= (DesignatorAssignExpression) Designator Assignop Expr
						|
						(DesignatorAssignExprError) Designator Assignop error
						|
						(DesignatorActivate) Designator LPARENT ActivateParametersOptional RPAREN
						|
						(DesignatorIncrementing) Designator INCREMENT
						|
						(DesignatorDecrementing) Designator DECREMENT
						;

ActivateParametersOptional ::=
								(ActivateParametersOptionalValue) ActivateParameters
								|
								(ActivateParametersEpsilon)
								;

ActivateParameters ::= 
					(ActivateParameters) Expression ActivateParametersExpressionList
					;
		
ActivateParametersExpressionList ::=
					(ActivateParametersExpressionListMember) ActivateParametersExpressionList COMMA Expression
					|
					(ActivateParametersExpressionListEpsilon)
					;

ExpressionOptional ::= 
						(ExpressionOptionalValue) Expression
						|
						(ExpressionOptionalEpsilon)
						;

Condition ::= 
				(Conditioning) ConditionTerm ConditionTermList
;

ConditionTermList ::= (ConditionTermListMember) ConditionTermList OR ConditionTerm
						|
						(ConditionTermEpsilon)
						;

ConditionTerm ::= (ConditionTerm) ConditionFact ConditionFactList
;

ConditionFactList ::= 
						(ConditionFacListMember) ConditionFactList AND ConditionFact
						|
						(ConditionFactEpsilon)
						;

ConditionFact ::= 	(ConditionFact) Expression ConditionFactRelopExpressionOptional
					|
					(ConditionFactEpsilon)
					;

Expression ::= 
				(Expression) MinusOptional ExpressionAddTermList
				;

ExpressionAddTermList ::= 
							(ExpressionAddTermListMember) ExpressionAddTermList Addop Term
							|
							(ExpressionAddTermEpsilon) Term
							;

Term ::= 
			(TermMulListMember) Term Mulop Factor;
			|
			(TermMulEpsion) Factor
			;


Factor ::= 
			(FactorDesignating) Designator FactorActivateParametersOptional
			|
			(FactorNum) NUMBER:fNum
			|
			(FactorChar) CHARCONST:fChar
			|
			(FactorBool) BOOLCONST:fBool
			|
			(FactorNew) NEW Type FactorExpressionOptional
			|
			(FactorExpression) LPAREN Expression RPAREN
			;

FactorExpressionOptional ::=
							(FactorExpressOptionalValue) LSQUARE Expression RSQUARE
							|
							(FactorExpressOptionalNoValue)
							;

FactorActivateParametersOptional ::=
					(FactorActivateParametersOptionalValue) LPAREN ActivateParametersOptional RPAREN
					|
					(FactorActivateParemeterOptionalNoValue)
					;

ConditionFactRelopExpressionOptional :=
		(ConditionFactRelopExpressionOptionalValue) Relop Expression
		|
		(ConditionFactRelopExpressionOptionalNoValue)
		;

ConditionOptional ::=
		(ConditionOptionalValue) Condition
		|
		(ConditionOptionalNoValue)
		;


DesigantorStatementOptional ::=
		(DesigantorStatementOptionalValue) DesigantorStatement
		|
		(DesigantorStatementOptionalNoValue)
		;

StatementElseOptional ::=
		(StatementElseOptionalValue) ELSE Statement
		|
		(StatementElseOptionalNoValue)
		;


Designator ::=
		(DesignatorDot) IDENT:dName DOT IDENT:rName
		|
		(DesignatorArray) ArrayDesignator LSQUARE Expression RSQUARE
		|
		(DesignatorDeclaration) IDENT:dName
		;

ArrayDesignator ::= 
		(ArrayDesignator) Designator
		;

Type ::= (Type) IDENT:typeName
;

Assignop ::= (AssignOperation) EQUAL
;

Relop ::=
		(RelopEquals) IDENTICAL
		|
		(RelopNotEquals) NOTIDENTICAL
		|
		(RelopGreater) GREATER
		|
		(RelopGreaterEquals) GREATEREQ
		|
		(RelopLess) LESS
		|
		(RelopLessEquals) LESSEQ
		;

Addop ::= 
		(AddopPlus) PLUS
		|
		(AddopMinus) MINUS
		;

Mulop ::=
		(MulopMul) MUL
		|
		(MulopDiv) DIV
		|
		(MulopMod) MOD
		;

