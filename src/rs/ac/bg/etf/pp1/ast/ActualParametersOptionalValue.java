// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class ActualParametersOptionalValue extends ActualParametersOptional {

    private ActualParameters ActualParameters;

    public ActualParametersOptionalValue (ActualParameters ActualParameters) {
        this.ActualParameters=ActualParameters;
        if(ActualParameters!=null) ActualParameters.setParent(this);
    }

    public ActualParameters getActualParameters() {
        return ActualParameters;
    }

    public void setActualParameters(ActualParameters ActualParameters) {
        this.ActualParameters=ActualParameters;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParameters!=null) ActualParameters.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParameters!=null) ActualParameters.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParameters!=null) ActualParameters.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParametersOptionalValue(\n");

        if(ActualParameters!=null)
            buffer.append(ActualParameters.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParametersOptionalValue]");
        return buffer.toString();
    }
}
