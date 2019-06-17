// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class VarsDeclarating extends ListVarDeclaration {

    private ListVarDeclaration ListVarDeclaration;
    private VarDeclaration VarDeclaration;

    public VarsDeclarating (ListVarDeclaration ListVarDeclaration, VarDeclaration VarDeclaration) {
        this.ListVarDeclaration=ListVarDeclaration;
        if(ListVarDeclaration!=null) ListVarDeclaration.setParent(this);
        this.VarDeclaration=VarDeclaration;
        if(VarDeclaration!=null) VarDeclaration.setParent(this);
    }

    public ListVarDeclaration getListVarDeclaration() {
        return ListVarDeclaration;
    }

    public void setListVarDeclaration(ListVarDeclaration ListVarDeclaration) {
        this.ListVarDeclaration=ListVarDeclaration;
    }

    public VarDeclaration getVarDeclaration() {
        return VarDeclaration;
    }

    public void setVarDeclaration(VarDeclaration VarDeclaration) {
        this.VarDeclaration=VarDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListVarDeclaration!=null) ListVarDeclaration.accept(visitor);
        if(VarDeclaration!=null) VarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListVarDeclaration!=null) ListVarDeclaration.traverseTopDown(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListVarDeclaration!=null) ListVarDeclaration.traverseBottomUp(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarsDeclarating(\n");

        if(ListVarDeclaration!=null)
            buffer.append(ListVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclaration!=null)
            buffer.append(VarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarsDeclarating]");
        return buffer.toString();
    }
}
