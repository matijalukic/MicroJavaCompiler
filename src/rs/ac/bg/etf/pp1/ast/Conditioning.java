// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class Conditioning extends Condition {

    private ConditionTerm ConditionTerm;
    private ConditionTermList ConditionTermList;

    public Conditioning (ConditionTerm ConditionTerm, ConditionTermList ConditionTermList) {
        this.ConditionTerm=ConditionTerm;
        if(ConditionTerm!=null) ConditionTerm.setParent(this);
        this.ConditionTermList=ConditionTermList;
        if(ConditionTermList!=null) ConditionTermList.setParent(this);
    }

    public ConditionTerm getConditionTerm() {
        return ConditionTerm;
    }

    public void setConditionTerm(ConditionTerm ConditionTerm) {
        this.ConditionTerm=ConditionTerm;
    }

    public ConditionTermList getConditionTermList() {
        return ConditionTermList;
    }

    public void setConditionTermList(ConditionTermList ConditionTermList) {
        this.ConditionTermList=ConditionTermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionTerm!=null) ConditionTerm.accept(visitor);
        if(ConditionTermList!=null) ConditionTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionTerm!=null) ConditionTerm.traverseTopDown(visitor);
        if(ConditionTermList!=null) ConditionTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionTerm!=null) ConditionTerm.traverseBottomUp(visitor);
        if(ConditionTermList!=null) ConditionTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Conditioning(\n");

        if(ConditionTerm!=null)
            buffer.append(ConditionTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionTermList!=null)
            buffer.append(ConditionTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Conditioning]");
        return buffer.toString();
    }
}
