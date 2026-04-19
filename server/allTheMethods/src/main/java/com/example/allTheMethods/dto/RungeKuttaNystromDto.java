package com.example.allTheMethods.dto;

import java.util.List;

public class RungeKuttaNystromDto extends SubmissionDataDto{
    private int iterations;
    private double hParameter;
    private double yZero;
    private double xZero;
    private double yPrimeZero;
    private double xPrimeZero;

    public RungeKuttaNystromDto(List<Double> inp, String problemString, int iterations, double hParameter, double yZero, double xZero, double yPrimeZero, double xPrimeZero) {
        super(inp, problemString);
        this.iterations = iterations;
        this.hParameter = hParameter;
        this.yZero = yZero;
        this.xZero = xZero;
        this.yPrimeZero = yPrimeZero;
        this.xPrimeZero = xPrimeZero;
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

    public double getyZero() {
        return yZero;
    }

    public void setyZero(double yZero) {
        this.yZero = yZero;
    }

    public double getxZero() {
        return xZero;
    }

    public void setxZero(double xZero) {
        this.xZero = xZero;
    }

    public double getyPrimeZero() {
        return yPrimeZero;
    }

    public void setyPrimeZero(double yPrimeZero) {
        this.yPrimeZero = yPrimeZero;
    }

    public double getxPrimeZero() {
        return xPrimeZero;
    }

    public void setxPrimeZero(double xPrimeZero) {
        this.xPrimeZero = xPrimeZero;
    }
}
