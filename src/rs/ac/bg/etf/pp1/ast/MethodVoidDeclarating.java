// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class MethodVoidDeclarating extends MethodTypeDeclaration {

    private String mName;

    public MethodVoidDeclarating (String mName) {
        this.mName=mName;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName=mName;
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
        buffer.append("MethodVoidDeclarating(\n");

        buffer.append(" "+tab+mName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodVoidDeclarating]");
        return buffer.toString();
    }
}
