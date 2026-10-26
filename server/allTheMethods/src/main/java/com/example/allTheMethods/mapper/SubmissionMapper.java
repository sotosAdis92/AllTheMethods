package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.request.CreateSubmissionRequest;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.entity.Submission;
import org.springframework.data.domain.Page;
import java.util.List;


public interface SubmissionMapper {
    SubmissionResponse toDto(Submission submission);
    List<SubmissionResponse> toDto(List<Submission> submissions);
    Page<SubmissionResponse> toDto(Page<Submission> submissionPage);
    Submission toEntity(CreateSubmissionRequest createSubmissionRequest);
}
