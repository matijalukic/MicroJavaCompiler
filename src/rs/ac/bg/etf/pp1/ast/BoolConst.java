// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class BoolConst extends ConstDeclarationValue {

    private Type Type;
    private String vName;
    private Assignop Assignop;
    private Boolean cBool;

    public BoolConst (Type Type, String vName, Assignop Assignop, Boolean cBool) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.vName=vName;
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.cBool=cBool;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName=vName;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public Boolean getCBool() {
        return cBool;
    }

    public void setCBool(Boolean cBool) {
        this.cBool=cBool;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BoolConst(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+vName);
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+cBool);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConst]");
        return buffer.toString();
    }
}
