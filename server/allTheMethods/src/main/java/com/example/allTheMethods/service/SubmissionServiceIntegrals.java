package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SimpsonDataRequest;
import com.example.allTheMethods.dto.request.TrapezodialRuleRequest;


public interface SubmissionServiceIntegrals {
    boolean trapezodialRule(TrapezodialRuleRequest trapezodialRuleDataDto);
    boolean simpson(SimpsonDataRequest simpsonDataRequest);
}
