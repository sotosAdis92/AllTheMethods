package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.*;

import java.util.List;


public interface SubmissionService {
    SubmissionDto createSubmission(SubmissionDto submissionDto);
    List<SubmissionDto> getSubmissionsByUserId(int id);
}
