package com.example.allTheMethods.ast;

public class Pow extends BinaryOperation{
    public Pow(Operation left, Operation right){
        super(left,right);
    }
    public String toString(){
        return "(" + left.toString() + ")^(" + right.toString() + ")";
    }
    @Override
    public Double getNumericResult(Double val){
        return Math.pow(left.getNumericResult(val), right.getNumericResult(val));
    }
    @Override
    public boolean equals(Object o){
        if(this ==o) return true;
        if(!(o instanceof Pow)) return false;
        Pow pow = (Pow) o;
        return left.equals(pow.left) && right.equals(pow.right);
    }
    public int hashCode(){
        return 71 * left.hashCode() + right.hashCode();
    }

}
