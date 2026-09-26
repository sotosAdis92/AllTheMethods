package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SimpsonDataDto;
import com.example.allTheMethods.dto.request.TrapezodialRuleDataDto;


public interface SubmissionServiceIntegrals {
    boolean trapezodialRule(TrapezodialRuleDataDto trapezodialRuleDataDto);
    boolean simpson(SimpsonDataDto simpsonDataDto);
}
