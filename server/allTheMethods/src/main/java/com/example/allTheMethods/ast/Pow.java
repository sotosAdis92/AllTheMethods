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
    public Operation getDerivative() {
        Operation firstTerm = new Pow(left, right);
        Operation secondTerm = new Addition(new Multiplication(right.getDerivative(), new Log(left)), new Division(new Multiplication(right, left.getDerivative()), left));
        return new Multiplication(firstTerm, secondTerm);
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
