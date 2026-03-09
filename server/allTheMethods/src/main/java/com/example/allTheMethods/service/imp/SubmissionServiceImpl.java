package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.SubmissionDto;
import com.example.allTheMethods.repository.SubmissionRepository;
import com.example.allTheMethods.service.SubmmisionService;

public class SubmissionServiceImpl implements SubmmisionService {
    private SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public SubmissionDto createSubmission(SubmissionDto submissionDto) {
        return null;
    }
}
