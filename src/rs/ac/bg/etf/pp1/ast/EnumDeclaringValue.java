// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class EnumDeclaringValue extends EnumValue {

    private String cName;
    private Assignop Assignop;
    private Integer cNum;

    public EnumDeclaringValue (String cName, Assignop Assignop, Integer cNum) {
        this.cName=cName;
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.cNum=cNum;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName=cName;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public Integer getCNum() {
        return cNum;
    }

    public void setCNum(Integer cNum) {
        this.cNum=cNum;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Assignop!=null) Assignop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDeclaringValue(\n");

        buffer.append(" "+tab+cName);
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+cNum);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDeclaringValue]");
        return buffer.toString();
    }
}
