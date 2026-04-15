package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import org.springframework.stereotype.Service;

@Service
public interface SubmissionServiceIntegrals {
    boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto);
    boolean checkSimpsonData();
    boolean checkRombergData();
}
