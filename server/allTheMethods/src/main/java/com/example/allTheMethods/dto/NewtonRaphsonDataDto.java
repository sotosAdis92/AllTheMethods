package com.example.allTheMethods.dto;

import java.util.List;

public class NewtonRaphsonDataDto extends SubmissionDataDto{
    private int iterations;
    private int xo;

    public NewtonRaphsonDataDto() {
    }

    public NewtonRaphsonDataDto(List<Double> inp, String problemString, int iterations, int xo) {
        super(inp, problemString);
        this.iterations = iterations;
        this.xo = xo;
    }

    public NewtonRaphsonDataDto(int iterations, int xo) {
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
