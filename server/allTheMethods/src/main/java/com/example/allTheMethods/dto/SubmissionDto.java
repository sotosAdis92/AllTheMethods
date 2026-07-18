package com.example.allTheMethods.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubmissionDto {
    private Long submissionId;
    private Long userId;
    private Long problemId;
    private String submittedAt;

    public SubmissionDto() {
    }

    public SubmissionDto(Long submissionId, Long userId, Long problemId, String submittedAt) {
        this.submissionId = submissionId;
        this.userId = userId;
        this.problemId = problemId;
        this.submittedAt = submittedAt;
    }

    public SubmissionDto(Long submissionId, Long userId, Long problemId, String submittedAt, String valid) {
        this.submissionId = submissionId;
        this.userId = userId;
        this.problemId = problemId;
        this.submittedAt = submittedAt;
    }
}
