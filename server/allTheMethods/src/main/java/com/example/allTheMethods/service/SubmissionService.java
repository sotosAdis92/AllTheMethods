package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.dto.response.SubmissionResponse;

import java.util.List;


public interface SubmissionService {
    SubmissionDto createSubmission(SubmissionDto submissionDto);
    List<SubmissionResponse> getSubmissionsByUserId(int id);
}
