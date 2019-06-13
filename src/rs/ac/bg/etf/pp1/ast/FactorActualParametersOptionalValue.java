// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class FactorActualParametersOptionalValue extends FactorActualParametersOptional {

    private ActualParametersOptional ActualParametersOptional;

    public FactorActualParametersOptionalValue (ActualParametersOptional ActualParametersOptional) {
        this.ActualParametersOptional=ActualParametersOptional;
        if(ActualParametersOptional!=null) ActualParametersOptional.setParent(this);
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
        if(ActualParametersOptional!=null) ActualParametersOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParametersOptional!=null) ActualParametersOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParametersOptional!=null) ActualParametersOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorActualParametersOptionalValue(\n");

        if(ActualParametersOptional!=null)
            buffer.append(ActualParametersOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorActualParametersOptionalValue]");
        return buffer.toString();
    }
}
