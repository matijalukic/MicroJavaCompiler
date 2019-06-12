// generated with ast extension for cup
// version 0.8
// 11/5/2019 14:0:28


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActivate extends DesigantorStatement {

    private Designator Designator;
    private ActivateParametersOptional ActivateParametersOptional;

    public DesignatorActivate (Designator Designator, ActivateParametersOptional ActivateParametersOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActivateParametersOptional=ActivateParametersOptional;
        if(ActivateParametersOptional!=null) ActivateParametersOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActivateParametersOptional getActivateParametersOptional() {
        return ActivateParametersOptional;
    }

    public void setActivateParametersOptional(ActivateParametersOptional ActivateParametersOptional) {
        this.ActivateParametersOptional=ActivateParametersOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActivateParametersOptional!=null) ActivateParametersOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActivateParametersOptional!=null) ActivateParametersOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActivateParametersOptional!=null) ActivateParametersOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActivate(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActivateParametersOptional!=null)
            buffer.append(ActivateParametersOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActivate]");
        return buffer.toString();
    }
}
