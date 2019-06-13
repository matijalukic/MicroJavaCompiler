// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class ProgramVarDeclarating extends ProgramListVarDeclaration {

    private ProgramListVarDeclaration ProgramListVarDeclaration;
    private VarDeclaration VarDeclaration;

    public ProgramVarDeclarating (ProgramListVarDeclaration ProgramListVarDeclaration, VarDeclaration VarDeclaration) {
        this.ProgramListVarDeclaration=ProgramListVarDeclaration;
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.setParent(this);
        this.VarDeclaration=VarDeclaration;
        if(VarDeclaration!=null) VarDeclaration.setParent(this);
    }

    public ProgramListVarDeclaration getProgramListVarDeclaration() {
        return ProgramListVarDeclaration;
    }

    public void setProgramListVarDeclaration(ProgramListVarDeclaration ProgramListVarDeclaration) {
        this.ProgramListVarDeclaration=ProgramListVarDeclaration;
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
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.accept(visitor);
        if(VarDeclaration!=null) VarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.traverseTopDown(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.traverseBottomUp(visitor);
        if(VarDeclaration!=null) VarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramVarDeclarating(\n");

        if(ProgramListVarDeclaration!=null)
            buffer.append(ProgramListVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclaration!=null)
            buffer.append(VarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramVarDeclarating]");
        return buffer.toString();
    }
}
