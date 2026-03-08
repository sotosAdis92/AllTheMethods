package com.example.allTheMethods.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class SubmissionDto {
    private Long submissionId;
    private Long userId;
    private Long problemId;
    private Date submittedAt;

    public SubmissionDto() {
    }

    public SubmissionDto(Long submissionId, Long userId, Long problemId, Date submittedAt) {
        this.submissionId = submissionId;
        this.userId = userId;
        this.problemId = problemId;
        this.submittedAt = submittedAt;
    }

    public Long getSubmissionId() {
        return submissionId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }
}
