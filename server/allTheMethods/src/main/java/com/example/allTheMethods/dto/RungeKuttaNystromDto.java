package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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
}
