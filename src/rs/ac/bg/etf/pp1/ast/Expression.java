// generated with ast extension for cup
// version 0.8
// 13/5/2019 11:29:5


package rs.ac.bg.etf.pp1.ast;

public class Expression implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private MinusOptional MinusOptional;
    private ExpressionAddTermList ExpressionAddTermList;

    public Expression (MinusOptional MinusOptional, ExpressionAddTermList ExpressionAddTermList) {
        this.MinusOptional=MinusOptional;
        if(MinusOptional!=null) MinusOptional.setParent(this);
        this.ExpressionAddTermList=ExpressionAddTermList;
        if(ExpressionAddTermList!=null) ExpressionAddTermList.setParent(this);
    }

    public MinusOptional getMinusOptional() {
        return MinusOptional;
    }

    public void setMinusOptional(MinusOptional MinusOptional) {
        this.MinusOptional=MinusOptional;
    }

    public ExpressionAddTermList getExpressionAddTermList() {
        return ExpressionAddTermList;
    }

    public void setExpressionAddTermList(ExpressionAddTermList ExpressionAddTermList) {
        this.ExpressionAddTermList=ExpressionAddTermList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MinusOptional!=null) MinusOptional.accept(visitor);
        if(ExpressionAddTermList!=null) ExpressionAddTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusOptional!=null) MinusOptional.traverseTopDown(visitor);
        if(ExpressionAddTermList!=null) ExpressionAddTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusOptional!=null) MinusOptional.traverseBottomUp(visitor);
        if(ExpressionAddTermList!=null) ExpressionAddTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expression(\n");

        if(MinusOptional!=null)
            buffer.append(MinusOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExpressionAddTermList!=null)
            buffer.append(ExpressionAddTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expression]");
        return buffer.toString();
    }
}
