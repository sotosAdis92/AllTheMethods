package com.example.allTheMethods.dto.request;

public class DiakritiNewtonRaphsonRequest extends SubmissionRequest {
    private int iterations;
    private int hParameter;
    private int xoParameter;

    public DiakritiNewtonRaphsonRequest() {
    }

    public int getIterations() {
        return iterations;
    }

    public int gethParameter() {
        return hParameter;
    }

    public int getXoParameter() {
        return xoParameter;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void sethParameter(int hParameter) {
        this.hParameter = hParameter;
    }

    public void setXoParameter(int xoParameter) {
        this.xoParameter = xoParameter;
    }
}
