// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListError2 extends VarDeclarationList {

    private VarListElem VarListElem;

    public VarDeclListError2 (VarListElem VarListElem) {
        this.VarListElem=VarListElem;
        if(VarListElem!=null) VarListElem.setParent(this);
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
        if(VarListElem!=null) VarListElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarListElem!=null) VarListElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarListElem!=null) VarListElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListError2(\n");

        if(VarListElem!=null)
            buffer.append(VarListElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListError2]");
        return buffer.toString();
    }
}
