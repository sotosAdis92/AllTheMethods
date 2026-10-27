package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SimpsonDataRequest;
import com.example.allTheMethods.dto.request.TrapezoidalRuleRequest;


public interface SubmissionServiceIntegrals {
    boolean trapezodialRule(TrapezoidalRuleRequest trapezodialRuleDataDto);
    boolean simpson(SimpsonDataRequest simpsonDataRequest);
}
