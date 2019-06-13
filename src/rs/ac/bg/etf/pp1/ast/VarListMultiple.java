// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class VarListMultiple extends VarDeclarationList {

    private VarDeclarationList VarDeclarationList;
    private VarListElem VarListElem;

    public VarListMultiple (VarDeclarationList VarDeclarationList, VarListElem VarListElem) {
        this.VarDeclarationList=VarDeclarationList;
        if(VarDeclarationList!=null) VarDeclarationList.setParent(this);
        this.VarListElem=VarListElem;
        if(VarListElem!=null) VarListElem.setParent(this);
    }

    public VarDeclarationList getVarDeclarationList() {
        return VarDeclarationList;
    }

    public void setVarDeclarationList(VarDeclarationList VarDeclarationList) {
        this.VarDeclarationList=VarDeclarationList;
    }

    public VarListElem getVarListElem() {
        return VarListElem;
    }

    public void setVarListElem(VarListElem VarListElem) {
        this.VarListElem=VarListElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclarationList!=null) VarDeclarationList.accept(visitor);
        if(VarListElem!=null) VarListElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseTopDown(visitor);
        if(VarListElem!=null) VarListElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationList!=null) VarDeclarationList.traverseBottomUp(visitor);
        if(VarListElem!=null) VarListElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarListMultiple(\n");

        if(VarDeclarationList!=null)
            buffer.append(VarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarListElem!=null)
            buffer.append(VarListElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarListMultiple]");
        return buffer.toString();
    }
}
