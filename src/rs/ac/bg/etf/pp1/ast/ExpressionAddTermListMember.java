// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class ExpressionAddTermListMember extends ExpressionAddTermList {

    private ExpressionAddTermList ExpressionAddTermList;
    private Addop Addop;
    private Term Term;

    public ExpressionAddTermListMember (ExpressionAddTermList ExpressionAddTermList, Addop Addop, Term Term) {
        this.ExpressionAddTermList=ExpressionAddTermList;
        if(ExpressionAddTermList!=null) ExpressionAddTermList.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ExpressionAddTermList getExpressionAddTermList() {
        return ExpressionAddTermList;
    }

    public void setExpressionAddTermList(ExpressionAddTermList ExpressionAddTermList) {
        this.ExpressionAddTermList=ExpressionAddTermList;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExpressionAddTermList!=null) ExpressionAddTermList.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExpressionAddTermList!=null) ExpressionAddTermList.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExpressionAddTermList!=null) ExpressionAddTermList.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionAddTermListMember(\n");

        if(ExpressionAddTermList!=null)
            buffer.append(ExpressionAddTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionAddTermListMember]");
        return buffer.toString();
    }
}
