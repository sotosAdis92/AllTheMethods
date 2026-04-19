package com.example.allTheMethods.dto;

import java.util.List;

public class RungeKuttaDataDto extends SubmissionDataDto{
    private double hParameter;
    private double yZero;
    private double xZero;

    public RungeKuttaDataDto(List<Double> inp, String problemString, double hParameter, double yZero, double xZero) {
        super(inp, problemString);
        this.hParameter = hParameter;
        this.yZero = yZero;
        this.xZero = xZero;
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
}
