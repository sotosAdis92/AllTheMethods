package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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
}
