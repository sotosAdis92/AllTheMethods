package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.SimpsonDataDto;
import com.example.allTheMethods.dto.TrapezodialRuleDataDto;


public interface SubmissionServiceIntegrals {
    boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto);
    boolean checkSimpsonData(SimpsonDataDto simpsonDataDto);
}
