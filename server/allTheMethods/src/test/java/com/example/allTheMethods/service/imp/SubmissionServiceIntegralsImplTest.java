package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.TrapezodialRuleDataDto;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionServiceIntegralsImplTest {
    @Test
    public void testingTrapezodalRuleTestCase() throws TokenizerException{
        SubmissionServiceIntegralsImpl submissionServiceIntegrals = new SubmissionServiceIntegralsImpl();
        TrapezodialRuleDataDto trpdto = new TrapezodialRuleDataDto();
        List<Double> testingInputs = new ArrayList<>();
        testingInputs.add(1.0);
        testingInputs.add(0.5);
        testingInputs.add(0.33333);
        try{
        assertEquals(true, submissionServiceIntegrals.checkTrapezodialRuleData(trpdto));
        } catch (IllegalArgumentException illegalArgumentException){
          System.out.println("Token exception");
        }
    }
}