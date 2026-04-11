package com.example.allTheMethods.ast;

public class Division extends BinaryOperation{
    public Division(Operation left, Operation right){
        super(left, right);
    }
    public Operation getLeft(){
        return left;
    }
    public Operation getRight(){
        return right;
    }
    public String toString(){
        return "(" + left.toString() + ")/(" + right.toString() + ")";
    }
    @Override
    public Double getNumericResult(Double val){
        return left.getNumericResult(val) / right.getNumericResult(val);
    }

    @Override
    public Operation getDerivative() {
        Operation numerator = new Subtraction(new Multiplication(left.getDerivative(), right), new Multiplication(left, right.getDerivative()));
        Operation denominator = new Pow(right, new Constant("2"));
        return new Division(numerator, denominator);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Division)) return false;
        Division division = (Division) obj;
        return left.equals(division.left) && right.equals(division.right);
    }
    public int hashCode(){
        return 67 * (left.hashCode() + right.hashCode());
    }
}
