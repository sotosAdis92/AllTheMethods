package com.example.allTheMethods.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DirectEulerDto extends SubmissionDataDto{
    private int iterations;
    private double hParameter;
    private double yZero;
    private double xZero;

    public DirectEulerDto(List<Double> inp, String problemString, int iterations, double hParameter, double yZero, double xZero) {
        super(inp, problemString);
        this.iterations = iterations;
        this.hParameter = hParameter;
        this.yZero = yZero;
        this.xZero = xZero;
    }
}
