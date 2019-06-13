// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignating extends Factor {

    private Designator Designator;
    private FactorActualParametersOptional FactorActualParametersOptional;

    public FactorDesignating (Designator Designator, FactorActualParametersOptional FactorActualParametersOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorActualParametersOptional=FactorActualParametersOptional;
        if(FactorActualParametersOptional!=null) FactorActualParametersOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorActualParametersOptional getFactorActualParametersOptional() {
        return FactorActualParametersOptional;
    }

    public void setFactorActualParametersOptional(FactorActualParametersOptional FactorActualParametersOptional) {
        this.FactorActualParametersOptional=FactorActualParametersOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorActualParametersOptional!=null) FactorActualParametersOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorActualParametersOptional!=null) FactorActualParametersOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorActualParametersOptional!=null) FactorActualParametersOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignating(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorActualParametersOptional!=null)
            buffer.append(FactorActualParametersOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignating]");
        return buffer.toString();
    }
}
