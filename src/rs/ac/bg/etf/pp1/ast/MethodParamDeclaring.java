// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class MethodParamDeclaring extends MethodParam {

    private Type Type;
    private String pName;
    private ArrayDeclaresOptional ArrayDeclaresOptional;

    public MethodParamDeclaring (Type Type, String pName, ArrayDeclaresOptional ArrayDeclaresOptional) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.pName=pName;
        this.ArrayDeclaresOptional=ArrayDeclaresOptional;
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName=pName;
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
        if(Type!=null) Type.accept(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayDeclaresOptional!=null) ArrayDeclaresOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodParamDeclaring(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+pName);
        buffer.append("\n");

        if(ArrayDeclaresOptional!=null)
            buffer.append(ArrayDeclaresOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodParamDeclaring]");
        return buffer.toString();
    }
}
