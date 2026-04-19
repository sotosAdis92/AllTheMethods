package com.example.allTheMethods.dto;

import java.util.List;

public class ImprovedEulerDto extends SubmissionDataDto{
    private int iterations;
    private double hParameter;
    private double yZero;
    private double xZero;

    public ImprovedEulerDto(List<Double> inp, String problemString, int iterations, double hParameter, double yZero, double xZero) {
        super(inp, problemString);
        this.iterations = iterations;
        this.hParameter = hParameter;
        this.yZero = yZero;
        this.xZero = xZero;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public double gethParameter() {
        return hParameter;
    }

    public void sethParameter(double hParameter) {
        this.hParameter = hParameter;
    }

    public double getxZero() {
        return xZero;
    }

    public void setxZero(double xZero) {
        this.xZero = xZero;
    }

    public double getyZero() {
        return yZero;
    }

    public void setyZero(double yZero) {
        this.yZero = yZero;
    }
}
