package com.example.allTheMethods.dto;

import java.util.List;

public class SubmissionDataDto extends SubmissionDto{
    private List<Double> inp;
    private int iterations;
    private int problemSpaceA;
    private int problemSpaceB;
    private String problemString;

    public SubmissionDataDto() {
    }

    public SubmissionDataDto(List<Double> inp, int iterations, int problemSpaceA, int problemSpaceB, String problemString) {

        this.inp = inp;
        this.iterations = iterations;
        this.problemSpaceA = problemSpaceA;
        this.problemSpaceB = problemSpaceB;
        this.problemString = problemString;
    }

    public List<Double> getInp() {
        return inp;
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

    public void setInp(List<Double> inp) {
        this.inp = inp;
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
