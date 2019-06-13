// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class EnumDeclarating extends EnumDeclaration {

    private EnumName EnumName;
    private EnumValue EnumValue;
    private EnumDeclarationList EnumDeclarationList;

    public EnumDeclarating (EnumName EnumName, EnumValue EnumValue, EnumDeclarationList EnumDeclarationList) {
        this.EnumName=EnumName;
        if(EnumName!=null) EnumName.setParent(this);
        this.EnumValue=EnumValue;
        if(EnumValue!=null) EnumValue.setParent(this);
        this.EnumDeclarationList=EnumDeclarationList;
        if(EnumDeclarationList!=null) EnumDeclarationList.setParent(this);
    }

    public EnumName getEnumName() {
        return EnumName;
    }

    public void setEnumName(EnumName EnumName) {
        this.EnumName=EnumName;
    }

    public EnumValue getEnumValue() {
        return EnumValue;
    }

    public void setEnumValue(EnumValue EnumValue) {
        this.EnumValue=EnumValue;
    }

    public EnumDeclarationList getEnumDeclarationList() {
        return EnumDeclarationList;
    }

    public void setEnumDeclarationList(EnumDeclarationList EnumDeclarationList) {
        this.EnumDeclarationList=EnumDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumName!=null) EnumName.accept(visitor);
        if(EnumValue!=null) EnumValue.accept(visitor);
        if(EnumDeclarationList!=null) EnumDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumName!=null) EnumName.traverseTopDown(visitor);
        if(EnumValue!=null) EnumValue.traverseTopDown(visitor);
        if(EnumDeclarationList!=null) EnumDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumName!=null) EnumName.traverseBottomUp(visitor);
        if(EnumValue!=null) EnumValue.traverseBottomUp(visitor);
        if(EnumDeclarationList!=null) EnumDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDeclarating(\n");

        if(EnumName!=null)
            buffer.append(EnumName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumValue!=null)
            buffer.append(EnumValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumDeclarationList!=null)
            buffer.append(EnumDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDeclarating]");
        return buffer.toString();
    }
}
