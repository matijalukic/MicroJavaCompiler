// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class ArrayDeclaringOptionalNoValue extends ArrayDeclaresOptional {

    public ArrayDeclaringOptionalNoValue () {
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
        buffer.append("ArrayDeclaringOptionalNoValue(\n");

        buffer.append(tab);
        buffer.append(") [ArrayDeclaringOptionalNoValue]");
        return buffer.toString();
    }
}