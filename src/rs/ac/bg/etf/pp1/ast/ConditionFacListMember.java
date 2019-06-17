// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class ConditionFacListMember extends ConditionFactList {

    private ConditionFactList ConditionFactList;
    private ConditionFact ConditionFact;

    public ConditionFacListMember (ConditionFactList ConditionFactList, ConditionFact ConditionFact) {
        this.ConditionFactList=ConditionFactList;
        if(ConditionFactList!=null) ConditionFactList.setParent(this);
        this.ConditionFact=ConditionFact;
        if(ConditionFact!=null) ConditionFact.setParent(this);
    }

    public ConditionFactList getConditionFactList() {
        return ConditionFactList;
    }

    public void setConditionFactList(ConditionFactList ConditionFactList) {
        this.ConditionFactList=ConditionFactList;
    }

    public ConditionFact getConditionFact() {
        return ConditionFact;
    }

    public void setConditionFact(ConditionFact ConditionFact) {
        this.ConditionFact=ConditionFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFactList!=null) ConditionFactList.accept(visitor);
        if(ConditionFact!=null) ConditionFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFactList!=null) ConditionFactList.traverseTopDown(visitor);
        if(ConditionFact!=null) ConditionFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFactList!=null) ConditionFactList.traverseBottomUp(visitor);
        if(ConditionFact!=null) ConditionFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFacListMember(\n");

        if(ConditionFactList!=null)
            buffer.append(ConditionFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFact!=null)
            buffer.append(ConditionFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFacListMember]");
        return buffer.toString();
    }
}
