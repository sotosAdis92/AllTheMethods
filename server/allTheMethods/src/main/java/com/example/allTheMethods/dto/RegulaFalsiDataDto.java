package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegulaFalsiDataDto extends SubmissionDataDto{
    private int iterations;
    private int problemSpaceA;
    private int problemSpaceB;

    public RegulaFalsiDataDto() {
    }

    public RegulaFalsiDataDto(int iterations, int problemSpaceA, int problemSpaceB) {
        this.iterations = iterations;
        this.problemSpaceA = problemSpaceA;
        this.problemSpaceB = problemSpaceB;
    }
}
