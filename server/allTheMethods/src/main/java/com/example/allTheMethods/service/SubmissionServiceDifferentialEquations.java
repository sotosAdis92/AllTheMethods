package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.DirectEulerDto;
import com.example.allTheMethods.dto.ImprovedEulerDto;
import com.example.allTheMethods.dto.RungeKuttaDataDto;
import com.example.allTheMethods.dto.RungeKuttaNystromDto;
import org.springframework.stereotype.Service;


public interface SubmissionServiceDifferentialEquations {
    boolean checkRungeKuttaData(RungeKuttaDataDto rungeKuttaDataDto);
    boolean checkRungeKuttaNystromData(RungeKuttaNystromDto rungeKuttaNystromDto);
    boolean checkImprovedEulerData(ImprovedEulerDto improvedEulerDto);
    boolean checkDirectEulerData(DirectEulerDto directEulerDto);
}
