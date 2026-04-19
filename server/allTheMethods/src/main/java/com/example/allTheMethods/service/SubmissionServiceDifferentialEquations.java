package com.example.allTheMethods.service;

import org.springframework.stereotype.Service;


public interface SubmissionServiceDifferentialEquations {
    boolean checkRungeKuttaData();
    boolean checkRungeKuttaNystromData();
    boolean checkImprovedEulerData();
    boolean checkDirectEulerData();
}
