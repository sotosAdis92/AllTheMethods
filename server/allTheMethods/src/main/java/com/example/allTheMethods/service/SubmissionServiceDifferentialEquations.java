package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.RungeKuttaDataDto;
import com.example.allTheMethods.dto.RungeKuttaNystromDto;
import org.springframework.stereotype.Service;


public interface SubmissionServiceDifferentialEquations {
    boolean checkRungeKuttaData(RungeKuttaDataDto rungeKuttaDataDto);
    boolean checkRungeKuttaNystromData(RungeKuttaNystromDto rungeKuttaNystromDto);
    boolean checkImprovedEulerData();
    boolean checkDirectEulerData();
}
