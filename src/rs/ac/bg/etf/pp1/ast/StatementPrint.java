// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class StatementPrint extends Statement {

    private Expression Expression;
    private StatementNumConstOptional StatementNumConstOptional;

    public StatementPrint (Expression Expression, StatementNumConstOptional StatementNumConstOptional) {
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
        this.StatementNumConstOptional=StatementNumConstOptional;
        if(StatementNumConstOptional!=null) StatementNumConstOptional.setParent(this);
    }

    public Expression getExpression() {
        return Expression;
    }

    public void setExpression(Expression Expression) {
        this.Expression=Expression;
    }

    public StatementNumConstOptional getStatementNumConstOptional() {
        return StatementNumConstOptional;
    }

    public void setStatementNumConstOptional(StatementNumConstOptional StatementNumConstOptional) {
        this.StatementNumConstOptional=StatementNumConstOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expression!=null) Expression.accept(visitor);
        if(StatementNumConstOptional!=null) StatementNumConstOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
        if(StatementNumConstOptional!=null) StatementNumConstOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        if(StatementNumConstOptional!=null) StatementNumConstOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementPrint(\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementNumConstOptional!=null)
            buffer.append(StatementNumConstOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementPrint]");
        return buffer.toString();
    }
}
