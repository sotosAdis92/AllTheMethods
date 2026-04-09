package com.example.allTheMethods.ast;

import jdk.dynalink.Operation;

public class Acos extends UnaryOperation{
    public Acos(Operation op){
        super(op);
    }

    public String toString(){
        return "acos(" + op.toString() + ")";
    }
    @Override
    public Double getNumericResut(Double val){
        return Math.acos(op.getNumbericResult(val));
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Acos)) return false;
        Acos acos = (Acos)o;
        return op.equals(acos.op);
    }

    public int hashCode(){
        return 11 * op.hashCode();
    }

}
