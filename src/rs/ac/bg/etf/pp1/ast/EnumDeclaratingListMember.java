// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class EnumDeclaratingListMember extends EnumDeclarationList {

    private EnumDeclarationList EnumDeclarationList;
    private EnumValue EnumValue;

    public EnumDeclaratingListMember (EnumDeclarationList EnumDeclarationList, EnumValue EnumValue) {
        this.EnumDeclarationList=EnumDeclarationList;
        if(EnumDeclarationList!=null) EnumDeclarationList.setParent(this);
        this.EnumValue=EnumValue;
        if(EnumValue!=null) EnumValue.setParent(this);
    }

    public EnumDeclarationList getEnumDeclarationList() {
        return EnumDeclarationList;
    }

    public void setEnumDeclarationList(EnumDeclarationList EnumDeclarationList) {
        this.EnumDeclarationList=EnumDeclarationList;
    }

    public EnumValue getEnumValue() {
        return EnumValue;
    }

    public void setEnumValue(EnumValue EnumValue) {
        this.EnumValue=EnumValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumDeclarationList!=null) EnumDeclarationList.accept(visitor);
        if(EnumValue!=null) EnumValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumDeclarationList!=null) EnumDeclarationList.traverseTopDown(visitor);
        if(EnumValue!=null) EnumValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumDeclarationList!=null) EnumDeclarationList.traverseBottomUp(visitor);
        if(EnumValue!=null) EnumValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDeclaratingListMember(\n");

        if(EnumDeclarationList!=null)
            buffer.append(EnumDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumValue!=null)
            buffer.append(EnumValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDeclaratingListMember]");
        return buffer.toString();
    }
}
