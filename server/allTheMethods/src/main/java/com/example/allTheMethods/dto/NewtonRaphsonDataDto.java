package com.example.allTheMethods.dto;

public class NewtonRaphsonDataDto extends SubmissionDataDto{
    private int iterations;
    private int xo;

    public NewtonRaphsonDataDto() {
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
