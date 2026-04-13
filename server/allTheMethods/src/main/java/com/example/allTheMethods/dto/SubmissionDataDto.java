package com.example.allTheMethods.dto;

import java.util.List;

public class SubmissionDataDto extends SubmissionDto{
    private List<Double> inp;
    private String problemType;
    private String problemString;

    public SubmissionDataDto() {
    }

    public SubmissionDataDto(Long submissionId, Long userId, Long problemId, String submittedAt, String valid, List<Double> inp, String problemType, String problemString) {
        super(submissionId, userId, problemId, submittedAt, valid);
        this.inp = inp;
        this.problemType = problemType;
        this.problemString = problemString;
    }

    public SubmissionDataDto(List<Double> inp, String problemString) {
        this.inp = inp;
        this.problemString = problemString;
    }

    public void setInp(List<Double> inp) {
        this.inp = inp;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public void setProblemString(String problemString) {
        this.problemString = problemString;
    }

    public List<Double> getInp() {
        return inp;
    }

    public String getProblemType() {
        return problemType;
    }

    public String getProblemString() {
        return problemString;
    }
}
