package com.example.allTheMethods.dto;

import java.util.List;

public class BisectionDataDto extends SubmissionDataDto{
    private int iterations;
    private int problemSpaceA;
    private int problemSpaceB;

    public BisectionDataDto() {
    }
    public BisectionDataDto(int iterations, int problemSpaceA, int problemSpaceB){
        super();
        this.iterations = iterations;
        this.problemSpaceA = problemSpaceA;
        this.problemSpaceB = problemSpaceB;
    }

    public BisectionDataDto(List<Double> inp, String problemString, int iterations, int problemSpaceA, int problemSpaceB) {
        super(inp, problemString);
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
