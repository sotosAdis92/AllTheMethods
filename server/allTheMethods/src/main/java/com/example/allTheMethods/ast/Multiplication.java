package com.example.allTheMethods.ast;

public class Multiplication extends BinaryOperation{
    public Multiplication(Operation left, Operation right){
        super(left, right);
    }
    public Operation getLeft(){
        return left;
    }
    public Operation getRight(){
        return right;
    }
    public String toString(){
        return "(" + left.toString() + ")*(" + right.toString() + ")";
    }


    @Override
    public Double getNumericResult(Double val) {
        return left.getNumericResult(val) * right.getNumericResult(val);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Multiplication)) return false;
        Multiplication abs = (Multiplication) o;
        return (left.equals(abs.left) && right.equals(abs.right));
    }

    public int hashCode(){
        return 73 * (left.hashCode() + right.hashCode());
    }

}
