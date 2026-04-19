package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.RungeKuttaDataDto;
import org.springframework.stereotype.Service;


public interface SubmissionServiceDifferentialEquations {
    boolean checkRungeKuttaData(RungeKuttaDataDto rungeKuttaDataDto);
    boolean checkRungeKuttaNystromData();
    boolean checkImprovedEulerData();
    boolean checkDirectEulerData();
}
