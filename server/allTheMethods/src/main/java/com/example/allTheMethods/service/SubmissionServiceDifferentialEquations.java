package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.DirectEulerDto;
import com.example.allTheMethods.dto.request.ImprovedEulerDto;
import com.example.allTheMethods.dto.request.RungeKuttaDataDto;
import com.example.allTheMethods.dto.request.RungeKuttaNystromDto;


public interface SubmissionServiceDifferentialEquations {
    boolean checkRungeKuttaData(RungeKuttaDataDto rungeKuttaDataDto);
    boolean checkRungeKuttaNystromData(RungeKuttaNystromDto rungeKuttaNystromDto);
    boolean checkImprovedEulerData(ImprovedEulerDto improvedEulerDto);
    boolean checkDirectEulerData(DirectEulerDto directEulerDto);
}
