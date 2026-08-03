package com.example.allTheMethods.service;

import com.example.allTheMethods.entity.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.allTheMethods.dto.request.CreateSubmissionRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;


public interface SubmissionService {
    SubmissionResponse createSubmission(CreateSubmissionRequestDto submissionDto);
    Page<Submission> getSubmissionsByUserId(int id, Pageable pageable);
}
