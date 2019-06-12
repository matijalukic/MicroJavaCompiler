// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class MethodParametersListing extends MethodParamsList {

    private MethodParamsList MethodParamsList;
    private Type Type;
    private String I3;
    private ArrayDeclaresOptional ArrayDeclaresOptional;

    public MethodParametersListing (MethodParamsList MethodParamsList, Type Type, String I3, ArrayDeclaresOptional ArrayDeclaresOptional) {
        this.MethodParamsList=MethodParamsList;
        if(MethodParamsList!=null) MethodParamsList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I3=I3;
        this.ArrayDeclaresOptional=ArrayDeclaresOptional;
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.setParent(this);
    }

    public MethodParamsList getMethodParamsList() {
        return MethodParamsList;
    }

    public void setMethodParamsList(MethodParamsList MethodParamsList) {
        this.MethodParamsList=MethodParamsList;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI3() {
        return I3;
    }

    public void setI3(String I3) {
        this.I3=I3;
    }

    public ArrayDeclaresOptional getArrayDeclaresOptional() {
        return ArrayDeclaresOptional;
    }

    public void setArrayDeclaresOptional(ArrayDeclaresOptional ArrayDeclaresOptional) {
        this.ArrayDeclaresOptional=ArrayDeclaresOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodParamsList!=null) MethodParamsList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodParamsList!=null) MethodParamsList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodParamsList!=null) MethodParamsList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodParametersListing(\n");

        if(MethodParamsList!=null)
            buffer.append(MethodParamsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I3);
        buffer.append("\n");

        if(ArrayDeclaresOptional!=null)
            buffer.append(ArrayDeclaresOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodParametersListing]");
        return buffer.toString();
    }
}
