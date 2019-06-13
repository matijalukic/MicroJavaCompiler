// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class ConditionFactRelopExpressionOptionalValue extends ConditionFactRelopExpressionOptional {

    private Relop Relop;
    private Expression Expression;

    public ConditionFactRelopExpressionOptionalValue (Relop Relop, Expression Expression) {
        this.Relop=Relop;
        if(Relop!=null) Relop.setParent(this);
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
    }

    public Relop getRelop() {
        return Relop;
    }

    public void setRelop(Relop Relop) {
        this.Relop=Relop;
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
        if(Relop!=null) Relop.accept(visitor);
        if(Expression!=null) Expression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Relop!=null) Relop.traverseTopDown(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Relop!=null) Relop.traverseBottomUp(visitor);
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFactRelopExpressionOptionalValue(\n");

        if(Relop!=null)
            buffer.append(Relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFactRelopExpressionOptionalValue]");
        return buffer.toString();
    }
}
