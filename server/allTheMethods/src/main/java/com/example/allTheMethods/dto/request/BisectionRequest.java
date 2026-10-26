package com.example.allTheMethods.dto.request;

import java.util.List;

public class BisectionRequest extends SubmissionRequest {
    private int iterations;
    private int problemSpaceA;
    private int problemSpaceB;

    public BisectionRequest() {
    }
    public BisectionRequest(int iterations, int problemSpaceA, int problemSpaceB){
        super();
        this.iterations = iterations;
        this.problemSpaceA = problemSpaceA;
        this.problemSpaceB = problemSpaceB;
    }

    public BisectionRequest(List<Double> inp, String problemString, int iterations, int problemSpaceA, int problemSpaceB) {
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
