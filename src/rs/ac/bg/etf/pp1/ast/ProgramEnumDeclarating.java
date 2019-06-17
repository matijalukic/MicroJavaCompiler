// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class ProgramEnumDeclarating extends ProgramListVarDeclaration {

    private ProgramListVarDeclaration ProgramListVarDeclaration;
    private EnumDeclaration EnumDeclaration;

    public ProgramEnumDeclarating (ProgramListVarDeclaration ProgramListVarDeclaration, EnumDeclaration EnumDeclaration) {
        this.ProgramListVarDeclaration=ProgramListVarDeclaration;
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.setParent(this);
        this.EnumDeclaration=EnumDeclaration;
        if(EnumDeclaration!=null) EnumDeclaration.setParent(this);
    }

    public ProgramListVarDeclaration getProgramListVarDeclaration() {
        return ProgramListVarDeclaration;
    }

    public void setProgramListVarDeclaration(ProgramListVarDeclaration ProgramListVarDeclaration) {
        this.ProgramListVarDeclaration=ProgramListVarDeclaration;
    }

    public EnumDeclaration getEnumDeclaration() {
        return EnumDeclaration;
    }

    public void setEnumDeclaration(EnumDeclaration EnumDeclaration) {
        this.EnumDeclaration=EnumDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.accept(visitor);
        if(EnumDeclaration!=null) EnumDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.traverseTopDown(visitor);
        if(EnumDeclaration!=null) EnumDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramListVarDeclaration!=null) ProgramListVarDeclaration.traverseBottomUp(visitor);
        if(EnumDeclaration!=null) EnumDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramEnumDeclarating(\n");

        if(ProgramListVarDeclaration!=null)
            buffer.append(ProgramListVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumDeclaration!=null)
            buffer.append(EnumDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramEnumDeclarating]");
        return buffer.toString();
    }
}
