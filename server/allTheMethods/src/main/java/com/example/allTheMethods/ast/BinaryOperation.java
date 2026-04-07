package com.example.allTheMethods.ast;

import jdk.dynalink.Operation;

public abstract class BinaryOperation implements Operation {
    final protected Operation left;
    final protected Operation right;

    public BinaryOperation(Operation left, Operation right) {
        this.left = left;
        this.right = right;
    }

    public Operation getLeft() {
        return left;
    }

    public Operation getRight() {
        return right;
    }
}
