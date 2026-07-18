package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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
}
