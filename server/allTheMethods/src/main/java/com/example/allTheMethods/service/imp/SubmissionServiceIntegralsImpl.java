package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceIntegralsImpl implements SubmissionServiceIntegrals {
    @Override
    public boolean checkTrapezodialRuleData(TrapezodialRuleDataDto trapezodialRuleDataDto) {
        boolean flag = false;

        return false;
    }

    @Override
    public boolean checkSimpsonData() {
        return false;
    }

    @Override
    public boolean checkRombergData() {
        return false;
    }
}
