package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SimpsonDataDto extends SubmissionDataDto{
    private int integrationSpaceA;
    private int integrationSpaceB;
    private double hParameter;

    public SimpsonDataDto(List<Double> inp, String problemString, int integrationSpaceA, int integrationSpaceB, double hParameter) {
        super(inp, problemString);
        this.integrationSpaceA = integrationSpaceA;
        this.integrationSpaceB = integrationSpaceB;
        this.hParameter = hParameter;
    }

    public SimpsonDataDto(List<Double> inp, String problemString) {
        super(inp, problemString);
    }
}
