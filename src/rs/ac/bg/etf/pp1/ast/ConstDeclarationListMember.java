// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationListMember extends ConstDeclarationList {

    private ConstDeclarationList ConstDeclarationList;
    private String vName;
    private Assignop Assignop;
    private ConstDeclarationValue ConstDeclarationValue;

    public ConstDeclarationListMember (ConstDeclarationList ConstDeclarationList, String vName, Assignop Assignop, ConstDeclarationValue ConstDeclarationValue) {
        this.ConstDeclarationList=ConstDeclarationList;
        if(ConstDeclarationList!=null) ConstDeclarationList.setParent(this);
        this.vName=vName;
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.ConstDeclarationValue=ConstDeclarationValue;
        if(ConstDeclarationValue!=null) ConstDeclarationValue.setParent(this);
    }

    public ConstDeclarationList getConstDeclarationList() {
        return ConstDeclarationList;
    }

    public void setConstDeclarationList(ConstDeclarationList ConstDeclarationList) {
        this.ConstDeclarationList=ConstDeclarationList;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName=vName;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public ConstDeclarationValue getConstDeclarationValue() {
        return ConstDeclarationValue;
    }

    public void setConstDeclarationValue(ConstDeclarationValue ConstDeclarationValue) {
        this.ConstDeclarationValue=ConstDeclarationValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclarationList!=null) ConstDeclarationList.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
        if(ConstDeclarationValue!=null) ConstDeclarationValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
        if(ConstDeclarationValue!=null) ConstDeclarationValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclarationList!=null) ConstDeclarationList.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        if(ConstDeclarationValue!=null) ConstDeclarationValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationListMember(\n");

        if(ConstDeclarationList!=null)
            buffer.append(ConstDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+vName);
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclarationValue!=null)
            buffer.append(ConstDeclarationValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationListMember]");
        return buffer.toString();
    }
}
