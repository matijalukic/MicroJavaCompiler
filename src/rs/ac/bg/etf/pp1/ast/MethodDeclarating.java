// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclarating extends MethodDeclaration {

    private MethodTypeDeclaration MethodTypeDeclaration;
    private MethodParamsOptional MethodParamsOptional;
    private ListVarDeclaration ListVarDeclaration;
    private StatementList StatementList;

    public MethodDeclarating (MethodTypeDeclaration MethodTypeDeclaration, MethodParamsOptional MethodParamsOptional, ListVarDeclaration ListVarDeclaration, StatementList StatementList) {
        this.MethodTypeDeclaration=MethodTypeDeclaration;
        if(MethodTypeDeclaration!=null) MethodTypeDeclaration.setParent(this);
        this.MethodParamsOptional=MethodParamsOptional;
        if(MethodParamsOptional!=null) MethodParamsOptional.setParent(this);
        this.ListVarDeclaration=ListVarDeclaration;
        if(ListVarDeclaration!=null) ListVarDeclaration.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodTypeDeclaration getMethodTypeDeclaration() {
        return MethodTypeDeclaration;
    }

    public void setMethodTypeDeclaration(MethodTypeDeclaration MethodTypeDeclaration) {
        this.MethodTypeDeclaration=MethodTypeDeclaration;
    }

    public MethodParamsOptional getMethodParamsOptional() {
        return MethodParamsOptional;
    }

    public void setMethodParamsOptional(MethodParamsOptional MethodParamsOptional) {
        this.MethodParamsOptional=MethodParamsOptional;
    }

    public ListVarDeclaration getListVarDeclaration() {
        return ListVarDeclaration;
    }

    public void setListVarDeclaration(ListVarDeclaration ListVarDeclaration) {
        this.ListVarDeclaration=ListVarDeclaration;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodTypeDeclaration!=null) MethodTypeDeclaration.accept(visitor);
        if(MethodParamsOptional!=null) MethodParamsOptional.accept(visitor);
        if(ListVarDeclaration!=null) ListVarDeclaration.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeDeclaration!=null) MethodTypeDeclaration.traverseTopDown(visitor);
        if(MethodParamsOptional!=null) MethodParamsOptional.traverseTopDown(visitor);
        if(ListVarDeclaration!=null) ListVarDeclaration.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeDeclaration!=null) MethodTypeDeclaration.traverseBottomUp(visitor);
        if(MethodParamsOptional!=null) MethodParamsOptional.traverseBottomUp(visitor);
        if(ListVarDeclaration!=null) ListVarDeclaration.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclarating(\n");

        if(MethodTypeDeclaration!=null)
            buffer.append(MethodTypeDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodParamsOptional!=null)
            buffer.append(MethodParamsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListVarDeclaration!=null)
            buffer.append(ListVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclarating]");
        return buffer.toString();
    }
}
