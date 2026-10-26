package com.example.allTheMethods.dto.request;

import java.util.List;

public class NewtonRaphsonRequest extends SubmissionRequest {
    private int iterations;
    private int xo;

    public NewtonRaphsonRequest() {
    }

    public NewtonRaphsonRequest(List<Double> inp, String problemString, int iterations, int xo) {
        super(inp, problemString);
        this.iterations = iterations;
        this.xo = xo;
    }

    public NewtonRaphsonRequest(int iterations, int xo) {
        this.iterations = iterations;
        this.xo = xo;
    }

    public int getIterations() {
        return iterations;
    }

    public int getXo() {
        return xo;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void setXo(int xo) {
        this.xo = xo;
    }
}
