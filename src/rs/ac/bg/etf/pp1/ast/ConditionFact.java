// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class ConditionFact implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expression Expression;
    private ConditionFactRelopExpressionOptional ConditionFactRelopExpressionOptional;

    public ConditionFact (Expression Expression, ConditionFactRelopExpressionOptional ConditionFactRelopExpressionOptional) {
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
        this.ConditionFactRelopExpressionOptional=ConditionFactRelopExpressionOptional;
        if(ConditionFactRelopExpressionOptional!=null) ConditionFactRelopExpressionOptional.setParent(this);
    }

    public Expression getExpression() {
        return Expression;
    }

    public void setExpression(Expression Expression) {
        this.Expression=Expression;
    }

    public ConditionFactRelopExpressionOptional getConditionFactRelopExpressionOptional() {
        return ConditionFactRelopExpressionOptional;
    }

    public void setConditionFactRelopExpressionOptional(ConditionFactRelopExpressionOptional ConditionFactRelopExpressionOptional) {
        this.ConditionFactRelopExpressionOptional=ConditionFactRelopExpressionOptional;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expression!=null) Expression.accept(visitor);
        if(ConditionFactRelopExpressionOptional!=null) ConditionFactRelopExpressionOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
        if(ConditionFactRelopExpressionOptional!=null) ConditionFactRelopExpressionOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        if(ConditionFactRelopExpressionOptional!=null) ConditionFactRelopExpressionOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFact(\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFactRelopExpressionOptional!=null)
            buffer.append(ConditionFactRelopExpressionOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFact]");
        return buffer.toString();
    }
}
