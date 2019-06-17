// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class MethodOptionalParamsDeclaring extends MethodParamsOptional {

    private MethodParams MethodParams;

    public MethodOptionalParamsDeclaring (MethodParams MethodParams) {
        this.MethodParams=MethodParams;
        if(MethodParams!=null) MethodParams.setParent(this);
    }

    public MethodParams getMethodParams() {
        return MethodParams;
    }

    public void setMethodParams(MethodParams MethodParams) {
        this.MethodParams=MethodParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodParams!=null) MethodParams.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodParams!=null) MethodParams.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodParams!=null) MethodParams.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodOptionalParamsDeclaring(\n");

        if(MethodParams!=null)
            buffer.append(MethodParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodOptionalParamsDeclaring]");
        return buffer.toString();
    }
}
