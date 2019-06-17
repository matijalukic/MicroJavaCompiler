// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class VarsDeclaratingEpsilon extends ListVarDeclaration {

    public VarsDeclaratingEpsilon () {
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
        buffer.append("VarsDeclaratingEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [VarsDeclaratingEpsilon]");
        return buffer.toString();
    }
}
