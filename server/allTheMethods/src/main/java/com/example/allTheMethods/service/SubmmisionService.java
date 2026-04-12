package com.example.allTheMethods.service;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface SubmmisionService {
    SubmissionDto createSubmission(SubmissionDto submissionDto);
    boolean checkDataBisection(BisectionDataDto bisectionDataDto);
    boolean checkDataRegulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto);
    boolean checkDataNewtonRaphson(NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException;
}
