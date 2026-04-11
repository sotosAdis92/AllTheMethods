package com.example.allTheMethods.ast;

public class Asin extends UnaryOperation{
    public Asin(Operation op){
        super(op);
    }
    public String toString(){
        return "asin(" + op.toString() + ")";
    }
    @Override
    public Double getNumericResult(Double val){
        return Math.asin(op.getNumericResult(val));
    }

    @Override
    public Operation getDerivative() {
        return null;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Asin)) return false;
        Asin asin = (Asin) o;
        return (op.equals(asin.op));
    }

    public int hashCode(){
        return 13 * op.hashCode();
    }
}
