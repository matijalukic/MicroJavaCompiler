// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class FactorExpressOptionalNoValue extends FactorExpressionOptional {

    public FactorExpressOptionalNoValue () {
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
        buffer.append("FactorExpressOptionalNoValue(\n");

        buffer.append(tab);
        buffer.append(") [FactorExpressOptionalNoValue]");
        return buffer.toString();
    }
}
