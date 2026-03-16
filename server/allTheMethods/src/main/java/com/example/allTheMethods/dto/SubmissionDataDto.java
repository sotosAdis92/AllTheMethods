package com.example.allTheMethods.dto;

import java.util.List;

public class SubmissionDataDto {
    private List<Float> Inputs;
    private int iterations;
    private int problemSpaceA;
    private int problemSpaceB;
    private String problemString;

    public SubmissionDataDto() {
    }

    public SubmissionDataDto( List<Float> inputs, int iterations, int problemSpaceA, int problemSpaceB, String problemString) {

        Inputs = inputs;
        this.iterations = iterations;
        this.problemSpaceA = problemSpaceA;
        this.problemSpaceB = problemSpaceB;
        this.problemString = problemString;
    }

    public List<Float> getInputs() {
        return Inputs;
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

    public String getProblemString() {
        return problemString;
    }

    public void setInputs(List<Float> inputs) {
        Inputs = inputs;
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

    public void setProblemString(String problemString) {
        this.problemString = problemString;
    }
}
