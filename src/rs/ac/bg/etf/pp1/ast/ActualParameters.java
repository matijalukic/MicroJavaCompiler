// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class ActualParameters implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expression Expression;
    private ActualParametersExpressionList ActualParametersExpressionList;

    public ActualParameters (Expression Expression, ActualParametersExpressionList ActualParametersExpressionList) {
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
        this.ActualParametersExpressionList=ActualParametersExpressionList;
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.setParent(this);
    }

    public Expression getExpression() {
        return Expression;
    }

    public void setExpression(Expression Expression) {
        this.Expression=Expression;
    }

    public ActualParametersExpressionList getActualParametersExpressionList() {
        return ActualParametersExpressionList;
    }

    public void setActualParametersExpressionList(ActualParametersExpressionList ActualParametersExpressionList) {
        this.ActualParametersExpressionList=ActualParametersExpressionList;
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
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParameters(\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActualParametersExpressionList!=null)
            buffer.append(ActualParametersExpressionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParameters]");
        return buffer.toString();
    }
}
