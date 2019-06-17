// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private DesignatorStatementOptional DesignatorStatementOptional;
    private ConditionOptional ConditionOptional;
    private DesignatorStatementOptional DesignatorStatementOptional1;
    private Statement Statement;

    public StatementFor (DesignatorStatementOptional DesignatorStatementOptional, ConditionOptional ConditionOptional, DesignatorStatementOptional DesignatorStatementOptional1, Statement Statement) {
        this.DesignatorStatementOptional=DesignatorStatementOptional;
        if(DesignatorStatementOptional!=null) DesignatorStatementOptional.setParent(this);
        this.ConditionOptional=ConditionOptional;
        if(ConditionOptional!=null) ConditionOptional.setParent(this);
        this.DesignatorStatementOptional1=DesignatorStatementOptional1;
        if(DesignatorStatementOptional1!=null) DesignatorStatementOptional1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public DesignatorStatementOptional getDesignatorStatementOptional() {
        return DesignatorStatementOptional;
    }

    public void setDesignatorStatementOptional(DesignatorStatementOptional DesignatorStatementOptional) {
        this.DesignatorStatementOptional=DesignatorStatementOptional;
    }

    public ConditionOptional getConditionOptional() {
        return ConditionOptional;
    }

    public void setConditionOptional(ConditionOptional ConditionOptional) {
        this.ConditionOptional=ConditionOptional;
    }

    public DesignatorStatementOptional getDesignatorStatementOptional1() {
        return DesignatorStatementOptional1;
    }

    public void setDesignatorStatementOptional1(DesignatorStatementOptional DesignatorStatementOptional1) {
        this.DesignatorStatementOptional1=DesignatorStatementOptional1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementOptional!=null) DesignatorStatementOptional.accept(visitor);
        if(ConditionOptional!=null) ConditionOptional.accept(visitor);
        if(DesignatorStatementOptional1!=null) DesignatorStatementOptional1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementOptional!=null) DesignatorStatementOptional.traverseTopDown(visitor);
        if(ConditionOptional!=null) ConditionOptional.traverseTopDown(visitor);
        if(DesignatorStatementOptional1!=null) DesignatorStatementOptional1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementOptional!=null) DesignatorStatementOptional.traverseBottomUp(visitor);
        if(ConditionOptional!=null) ConditionOptional.traverseBottomUp(visitor);
        if(DesignatorStatementOptional1!=null) DesignatorStatementOptional1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(DesignatorStatementOptional!=null)
            buffer.append(DesignatorStatementOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionOptional!=null)
            buffer.append(ConditionOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementOptional1!=null)
            buffer.append(DesignatorStatementOptional1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}
