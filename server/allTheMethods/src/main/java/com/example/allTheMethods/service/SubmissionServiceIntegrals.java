package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.SimpsonDataDto;
import com.example.allTheMethods.dto.request.TrapezodialRuleDataDto;


public interface SubmissionServiceIntegrals {
    boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto);
    boolean checkSimpsonData(SimpsonDataDto simpsonDataDto);
}
