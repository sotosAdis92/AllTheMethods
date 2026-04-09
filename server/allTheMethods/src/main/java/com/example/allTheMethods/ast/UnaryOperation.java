package com.example.allTheMethods.ast;


public abstract class UnaryOperation implements Operation {
    final Operation op;

    public UnaryOperation(Operation op) {
        this.op = op;
    }

    public Operation getOp() {
        return op;
    }
}
