package com.example.allTheMethods.ast;

public interface Operation {
    Double getNumericResult(Double val);
    Operation getDerivative(); //Derivative Method for each function
}
