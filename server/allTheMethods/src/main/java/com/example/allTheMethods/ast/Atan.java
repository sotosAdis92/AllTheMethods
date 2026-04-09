package com.example.allTheMethods.ast;

public class Atan extends UnaryOperation{
    public Atan(Operation op){
        super(op);
    }
    public String toString(){
        return "atan(" + op.toString() + ")";
    }
    @Override
    public Double getNumericResult(Double val){
        return Math.atan(op.getNumericResult(val));
    }
}
