// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class MethodParametersDeclaring extends MethodParams {

    private Type Type;
    private String fName;
    private ArrayDeclaresOptional ArrayDeclaresOptional;
    private MethodParamsList MethodParamsList;

    public MethodParametersDeclaring (Type Type, String fName, ArrayDeclaresOptional ArrayDeclaresOptional, MethodParamsList MethodParamsList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.fName=fName;
        this.ArrayDeclaresOptional=ArrayDeclaresOptional;
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.setParent(this);
        this.MethodParamsList=MethodParamsList;
        if(MethodParamsList!=null) MethodParamsList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName=fName;
    }

    public ArrayDeclaresOptional getArrayDeclaresOptional() {
        return ArrayDeclaresOptional;
    }

    public void setArrayDeclaresOptional(ArrayDeclaresOptional ArrayDeclaresOptional) {
        this.ArrayDeclaresOptional=ArrayDeclaresOptional;
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
        if(Type!=null) Type.accept(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.accept(visitor);
        if(MethodParamsList!=null) MethodParamsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.traverseTopDown(visitor);
        if(MethodParamsList!=null) MethodParamsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.traverseBottomUp(visitor);
        if(MethodParamsList!=null) MethodParamsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodParametersDeclaring(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+fName);
        buffer.append("\n");

        if(ArrayDeclaresOptional!=null)
            buffer.append(ArrayDeclaresOptional.toString("  "+tab));
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
