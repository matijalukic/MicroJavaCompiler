// generated with ast extension for cup
// version 0.8
// 11/5/2019 2:4:15


package rs.ac.bg.etf.pp1.ast;

public class ConditionTermListDerived1 extends ConditionTermList {

    public ConditionTermListDerived1 () {
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
        buffer.append("ConditionTermListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ConditionTermListDerived1]");
        return buffer.toString();
    }
}
