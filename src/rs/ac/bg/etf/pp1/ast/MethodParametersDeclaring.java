// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class MethodParametersDeclaring extends MethodParams {

    private MethodParam MethodParam;
    private MethodParamsList MethodParamsList;

    public MethodParametersDeclaring (MethodParam MethodParam, MethodParamsList MethodParamsList) {
        this.MethodParam=MethodParam;
        if(MethodParam!=null) MethodParam.setParent(this);
        this.MethodParamsList=MethodParamsList;
        if(MethodParamsList!=null) MethodParamsList.setParent(this);
    }

    public MethodParam getMethodParam() {
        return MethodParam;
    }

    public void setMethodParam(MethodParam MethodParam) {
        this.MethodParam=MethodParam;
    }

    public MethodParamsList getMethodParamsList() {
        return MethodParamsList;
    }

    public void setMethodParamsList(MethodParamsList MethodParamsList) {
        this.MethodParamsList=MethodParamsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodParam!=null) MethodParam.accept(visitor);
        if(MethodParamsList!=null) MethodParamsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodParam!=null) MethodParam.traverseTopDown(visitor);
        if(MethodParamsList!=null) MethodParamsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodParam!=null) MethodParam.traverseBottomUp(visitor);
        if(MethodParamsList!=null) MethodParamsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodParametersDeclaring(\n");

        if(MethodParam!=null)
            buffer.append(MethodParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodParamsList!=null)
            buffer.append(MethodParamsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodParametersDeclaring]");
        return buffer.toString();
    }
}
