package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.BisectionDataDto;
import com.example.allTheMethods.dto.RegulaFalsiDataDto;
import com.example.allTheMethods.dto.SubmissionDataDto;
import com.example.allTheMethods.dto.SubmissionDto;
import org.springframework.stereotype.Service;

@Service
public interface SubmmisionService {
    SubmissionDto createSubmission(SubmissionDto submissionDto);
    boolean checkDataBisection(BisectionDataDto bisectionDataDto);
    boolean checkDataRegulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto);
}
