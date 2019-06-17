// generated with ast extension for cup
// version 0.8
// 13/5/2019 23:19:57


package rs.ac.bg.etf.pp1.ast;

public class StatementNumConstOptionalValue extends StatementNumConstOptional {

    private Integer sNum;

    public StatementNumConstOptionalValue (Integer sNum) {
        this.sNum=sNum;
    }

    public Integer getSNum() {
        return sNum;
    }

    public void setSNum(Integer sNum) {
        this.sNum=sNum;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementNumConstOptionalValue(\n");

        buffer.append(" "+tab+sNum);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementNumConstOptionalValue]");
        return buffer.toString();
    }
}
