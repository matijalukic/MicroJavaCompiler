// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDot extends Designator {

    private String dName;
    private String rName;

    public DesignatorDot (String dName, String rName) {
        this.dName=dName;
        this.rName=rName;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName=dName;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName=rName;
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
        buffer.append("DesignatorDot(\n");

        buffer.append(" "+tab+dName);
        buffer.append("\n");

        buffer.append(" "+tab+rName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDot]");
        return buffer.toString();
    }
}
