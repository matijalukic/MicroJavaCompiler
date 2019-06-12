// generated with ast extension for cup
// version 0.8
// 12/5/2019 20:22:16


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private FactorExpressionOptional FactorExpressionOptional;

    public FactorNew (Type Type, FactorExpressionOptional FactorExpressionOptional) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorExpressionOptional=FactorExpressionOptional;
        if(FactorExpressionOptional!=null) FactorExpressionOptional.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorExpressionOptional getFactorExpressionOptional() {
        return FactorExpressionOptional;
    }

    public void setFactorExpressionOptional(FactorExpressionOptional FactorExpressionOptional) {
        this.FactorExpressionOptional=FactorExpressionOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorExpressionOptional!=null) FactorExpressionOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorExpressionOptional!=null) FactorExpressionOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorExpressionOptional!=null) FactorExpressionOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorExpressionOptional!=null)
            buffer.append(FactorExpressionOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
