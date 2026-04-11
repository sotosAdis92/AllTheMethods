package com.example.allTheMethods.ast;

public class Log extends UnaryOperation{
    public Log(Operation op) {
        super(op);
    }


    public String toString(){
        return "log(" + op.toString() + ")";
    }


    @Override
    public Double getNumericResult(Double val) {
        return Math.log(op.getNumericResult(val));
    }

    @Override
    public Operation getDerivative() {
        return new Division(op.getDerivative(), op);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log abs = (Log) o;
        return (op.equals(abs.op));
    }

    public int hashCode(){
        return 37 * op.hashCode();
    }

}
