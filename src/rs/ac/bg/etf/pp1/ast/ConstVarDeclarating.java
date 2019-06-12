// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class ConstVarDeclarating extends ConstDeclaration {

    private ConstDeclarationValue ConstDeclarationValue;
    private ConstDeclarationList ConstDeclarationList;

    public ConstVarDeclarating (ConstDeclarationValue ConstDeclarationValue, ConstDeclarationList ConstDeclarationList) {
        this.ConstDeclarationValue=ConstDeclarationValue;
        if(ConstDeclarationValue!=null) ConstDeclarationValue.setParent(this);
        this.ConstDeclarationList=ConstDeclarationList;
        if(ConstDeclarationList!=null) ConstDeclarationList.setParent(this);
    }

    public ConstDeclarationValue getConstDeclarationValue() {
        return ConstDeclarationValue;
    }

    public void setConstDeclarationValue(ConstDeclarationValue ConstDeclarationValue) {
        this.ConstDeclarationValue=ConstDeclarationValue;
    }

    public ConstDeclarationList getConstDeclarationList() {
        return ConstDeclarationList;
    }

    public void setConstDeclarationList(ConstDeclarationList ConstDeclarationList) {
        this.ConstDeclarationList=ConstDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclarationValue!=null) ConstDeclarationValue.accept(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclarationValue!=null) ConstDeclarationValue.traverseTopDown(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclarationValue!=null) ConstDeclarationValue.traverseBottomUp(visitor);
        if(ConstDeclarationList!=null) ConstDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstVarDeclarating(\n");

        if(ConstDeclarationValue!=null)
            buffer.append(ConstDeclarationValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclarationList!=null)
            buffer.append(ConstDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVarDeclarating]");
        return buffer.toString();
    }
}
