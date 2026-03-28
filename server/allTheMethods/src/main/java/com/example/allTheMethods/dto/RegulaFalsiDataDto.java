package com.example.allTheMethods.dto;

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

    public int getIterations() {
        return iterations;
    }

    public int getProblemSpaceA() {
        return problemSpaceA;
    }

    public int getProblemSpaceB() {
        return problemSpaceB;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void setProblemSpaceA(int problemSpaceA) {
        this.problemSpaceA = problemSpaceA;
    }

    public void setProblemSpaceB(int problemSpaceB) {
        this.problemSpaceB = problemSpaceB;
    }
}
