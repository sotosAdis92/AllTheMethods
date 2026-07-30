package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.dto.request.CreateSubmissionRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;

import java.util.List;


public interface SubmissionService {
    SubmissionResponse createSubmission(CreateSubmissionRequestDto submissionDto);
    List<SubmissionResponse> getSubmissionsByUserId(int id);
}
