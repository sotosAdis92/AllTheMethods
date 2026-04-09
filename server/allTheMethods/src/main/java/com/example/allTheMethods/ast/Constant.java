package com.example.allTheMethods.ast;

public class Constant implements Operation{
    private String value;
    public Constant(String value){
        this.value = value;
    }
    @Override
    public Double getNumericResult(Double val){
        return Double.parseDouble(value);
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Constant)) return false;
        Constant constant = (Constant) o;
        return (value.equals(constant.value));
    }
    public int hashCode(){
        return 23 * (int) Double.parseDouble(value);
    }
}
