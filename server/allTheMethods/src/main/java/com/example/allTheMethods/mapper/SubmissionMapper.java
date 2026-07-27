package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.entity.Submission;

import java.util.List;

public interface SubmissionMapper {
    SubmissionResponse toDto(Submission submission);
    List<SubmissionResponse> toDto(List<Submission> submissions);
}
