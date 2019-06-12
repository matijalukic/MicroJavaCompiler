// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class ActualParametersExpressionListMember extends ActualParametersExpressionList {

    private ActualParametersExpressionList ActualParametersExpressionList;
    private Expression Expression;

    public ActualParametersExpressionListMember (ActualParametersExpressionList ActualParametersExpressionList, Expression Expression) {
        this.ActualParametersExpressionList=ActualParametersExpressionList;
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.setParent(this);
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
    }

    public ActualParametersExpressionList getActualParametersExpressionList() {
        return ActualParametersExpressionList;
    }

    public void setActualParametersExpressionList(ActualParametersExpressionList ActualParametersExpressionList) {
        this.ActualParametersExpressionList=ActualParametersExpressionList;
    }

    public Expression getExpression() {
        return Expression;
    }

    public void setExpression(Expression Expression) {
        this.Expression=Expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.accept(visitor);
        if(Expression!=null) Expression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.traverseTopDown(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParametersExpressionList!=null) ActualParametersExpressionList.traverseBottomUp(visitor);
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParametersExpressionListMember(\n");

        if(ActualParametersExpressionList!=null)
            buffer.append(ActualParametersExpressionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParametersExpressionListMember]");
        return buffer.toString();
    }
}
