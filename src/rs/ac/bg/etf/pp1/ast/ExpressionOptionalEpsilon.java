// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class ExpressionOptionalEpsilon extends ExpressionOptional {

    public ExpressionOptionalEpsilon () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionOptionalEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ExpressionOptionalEpsilon]");
        return buffer.toString();
    }
}
