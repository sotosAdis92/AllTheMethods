package com.example.allTheMethods.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.allTheMethods.dto.request.CreateSubmissionRequest;
import com.example.allTheMethods.dto.response.SubmissionResponse;


public interface SubmissionService {
    SubmissionResponse createSubmission(CreateSubmissionRequest submissionDto);
    Page<SubmissionResponse> getSubmissionsByUserId(int id, Pageable pageable);
    Page<SubmissionResponse> getAllSubmissions(Pageable pageable);
}
