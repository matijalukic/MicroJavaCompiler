// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class StatementIf extends Statement {

    private Condition Condition;
    private Statement Statement;
    private StatementElseOptional StatementElseOptional;

    public StatementIf (Condition Condition, Statement Statement, StatementElseOptional StatementElseOptional) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.StatementElseOptional=StatementElseOptional;
        if(StatementElseOptional!=null) StatementElseOptional.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public StatementElseOptional getStatementElseOptional() {
        return StatementElseOptional;
    }

    public void setStatementElseOptional(StatementElseOptional StatementElseOptional) {
        this.StatementElseOptional=StatementElseOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(StatementElseOptional!=null) StatementElseOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(StatementElseOptional!=null) StatementElseOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(StatementElseOptional!=null) StatementElseOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementIf(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementElseOptional!=null)
            buffer.append(StatementElseOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementIf]");
        return buffer.toString();
    }
}
