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
    @Override
    public boolean equals(Object ob){
        if(this == ob) return true;
        if(!(ob instanceof Atan)) return false;
        Atan atan = (Atan)ob;
        return op.equals(atan.op);
    }
    public int hashCode(){
        return 17 * op.hashCode();
    }
}
