package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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
}
