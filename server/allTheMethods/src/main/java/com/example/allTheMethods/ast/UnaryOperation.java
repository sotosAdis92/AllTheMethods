package com.example.allTheMethods.ast;

import jdk.dynalink.Operation;

import java.awt.desktop.OpenFilesHandler;

public class UnaryOperation implements Operation {
    final Operation op;

    public UnaryOperation(Operation op) {
        this.op = op;
    }

    public Operation getOp() {
        return op;
    }
}
