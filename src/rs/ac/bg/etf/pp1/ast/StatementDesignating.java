// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class StatementDesignating extends Statement {

    private DesigantorStatement DesigantorStatement;

    public StatementDesignating (DesigantorStatement DesigantorStatement) {
        this.DesigantorStatement=DesigantorStatement;
        if(DesigantorStatement!=null) DesigantorStatement.setParent(this);
    }

    public DesigantorStatement getDesigantorStatement() {
        return DesigantorStatement;
    }

    public void setDesigantorStatement(DesigantorStatement DesigantorStatement) {
        this.DesigantorStatement=DesigantorStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesigantorStatement!=null) DesigantorStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesigantorStatement!=null) DesigantorStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesigantorStatement!=null) DesigantorStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDesignating(\n");

        if(DesigantorStatement!=null)
            buffer.append(DesigantorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDesignating]");
        return buffer.toString();
    }
}
