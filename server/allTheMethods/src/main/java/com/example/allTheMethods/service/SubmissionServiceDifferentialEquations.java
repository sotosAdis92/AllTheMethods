package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.DirectEulerDto;
import com.example.allTheMethods.dto.request.ImprovedEulerDto;
import com.example.allTheMethods.dto.request.RungeKuttaDataDto;
import com.example.allTheMethods.dto.request.RungeKuttaNystromDto;


public interface SubmissionServiceDifferentialEquations {
    boolean rungeKutta(RungeKuttaDataDto rungeKuttaDataDto);
    boolean rungeKuttaNystrom(RungeKuttaNystromDto rungeKuttaNystromDto);
    boolean improvedEuler(ImprovedEulerDto improvedEulerDto);
    boolean directEuler(DirectEulerDto directEulerDto);
}
