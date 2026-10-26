package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.DirectEulerRequest;
import com.example.allTheMethods.dto.request.ImprovedEulerRequest;
import com.example.allTheMethods.dto.request.RungeKuttaRequest;
import com.example.allTheMethods.dto.request.RungeKuttaNystromRequest;


public interface SubmissionServiceDifferentialEquations {
    boolean rungeKutta(RungeKuttaRequest rungeKuttaRequest);
    boolean rungeKuttaNystrom(RungeKuttaNystromRequest rungeKuttaNystromRequest);
    boolean improvedEuler(ImprovedEulerRequest improvedEulerRequest);
    boolean directEuler(DirectEulerRequest directEulerRequest);
}
