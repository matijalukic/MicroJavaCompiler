// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class ProgramConstVarDeclarating extends ProgramListVarDeclaration {

    private ProgramListVarDeclaration ProgramListVarDeclaration;
    private ConstDeclaration ConstDeclaration;

    public ProgramConstVarDeclarating (ProgramListVarDeclaration ProgramListVarDeclaration, ConstDeclaration ConstDeclaration) {
        this.ProgramListVarDeclaration=ProgramListVarDeclaration;
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.setParent(this);
        this.ConstDeclaration=ConstDeclaration;
        if(ConstDeclaration!=null) ConstDeclaration.setParent(this);
    }

    public ProgramListVarDeclaration getProgramListVarDeclaration() {
        return ProgramListVarDeclaration;
    }

    public void setProgramListVarDeclaration(ProgramListVarDeclaration ProgramListVarDeclaration) {
        this.ProgramListVarDeclaration=ProgramListVarDeclaration;
    }

    public ConstDeclaration getConstDeclaration() {
        return ConstDeclaration;
    }

    public void setConstDeclaration(ConstDeclaration ConstDeclaration) {
        this.ConstDeclaration=ConstDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.accept(visitor);
        if(ConstDeclaration!=null) ConstDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.traverseTopDown(visitor);
        if(ConstDeclaration!=null) ConstDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.traverseBottomUp(visitor);
        if(ConstDeclaration!=null) ConstDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramConstVarDeclarating(\n");

        if(ProgramListVarDeclaration!=null)
            buffer.append(ProgramListVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclaration!=null)
            buffer.append(ConstDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramConstVarDeclarating]");
        return buffer.toString();
    }
}
