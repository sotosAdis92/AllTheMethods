package com.example.allTheMethods.ast;

public class Cos extends UnaryOperation{
    public Cos(Operation op){
        super(op);
    }
    public String toString(){
        return "cos(" + op.toString() + ")";
    }

    @Override
    public Double getNumericResult(Double val){
        return Math.cos(op.getNumericResult(val));
    }

    @Override
    public Operation getDerivative() {
        return new Negate(new Multiplication(new Sin(op), op.getDerivative()));
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Cos)) return false;
        Cos cos = (Cos)o;
        return op.equals(cos.op);
    }

    public int hashCode(){
        return 29 * op.hashCode();
    }
}
