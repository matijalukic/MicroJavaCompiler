// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListError1 extends VarDeclarationList {

    private VarDeclarationList VarDeclarationList;

    public VarDeclListError1 (VarDeclarationList VarDeclarationList) {
        this.VarDeclarationList=VarDeclarationList;
        if(VarDeclarationList!=null) VarDeclarationList.setParent(this);
    }

    public VarDeclarationList getVarDeclarationList() {
        return VarDeclarationList;
    }

    public void setVarDeclarationList(VarDeclarationList VarDeclarationList) {
        this.VarDeclarationList=VarDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclarationList!=null) VarDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationList!=null) VarDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListError1(\n");

        if(VarDeclarationList!=null)
            buffer.append(VarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListError1]");
        return buffer.toString();
    }
}
