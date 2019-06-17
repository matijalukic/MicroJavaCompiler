// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class EnumDeclaringNoValue extends EnumValue {

    private String cName;

    public EnumDeclaringNoValue (String cName) {
        this.cName=cName;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName=cName;
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
        buffer.append("EnumDeclaringNoValue(\n");

        buffer.append(" "+tab+cName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDeclaringNoValue]");
        return buffer.toString();
    }
}
