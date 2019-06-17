// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActual extends DesigantorStatement {

    private Designator Designator;
    private ActualParametersOptional ActualParametersOptional;

    public DesignatorActual (Designator Designator, ActualParametersOptional ActualParametersOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActualParametersOptional=ActualParametersOptional;
        if(ActualParametersOptional!=null) ActualParametersOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActualParametersOptional getActualParametersOptional() {
        return ActualParametersOptional;
    }

    public void setActualParametersOptional(ActualParametersOptional ActualParametersOptional) {
        this.ActualParametersOptional=ActualParametersOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActualParametersOptional!=null) ActualParametersOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActualParametersOptional!=null) ActualParametersOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActualParametersOptional!=null) ActualParametersOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActual(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActualParametersOptional!=null)
            buffer.append(ActualParametersOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActual]");
        return buffer.toString();
    }
}
