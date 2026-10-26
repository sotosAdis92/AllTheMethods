package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.SimpsonDataRequest;
import com.example.allTheMethods.dto.request.TrapezodialRuleRequest;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionServiceIntegralsImplTest {
    @Test
    public void testingTrapezodalRuleTestCase() throws TokenizerException{
        SubmissionServiceIntegralsImpl submissionServiceIntegrals = new SubmissionServiceIntegralsImpl();
        TrapezodialRuleRequest trpdto = new TrapezodialRuleRequest();
        List<Double> testingInputs = new ArrayList<>();
        testingInputs.add(1.0);
        testingInputs.add(0.5);
        testingInputs.add(0.33333);
        try{
        assertEquals(true, submissionServiceIntegrals.trapezodialRule(trpdto));
        } catch (IllegalArgumentException illegalArgumentException){
          System.out.println("Token exception");
        }
    }

    @Test
    public void testSimposonRuleTestCase() throws TokenizerException{
        SubmissionServiceIntegralsImpl submissionServiceIntegrals = new SubmissionServiceIntegralsImpl();
        List<Double> testingInputs = new ArrayList<>();
        SimpsonDataRequest simpsonDataRequest = new SimpsonDataRequest(testingInputs,"x-2",1,3,0.5);
        testingInputs.add(1.0);
        testingInputs.add(0.5);
        testingInputs.add(0.33333);
        try{
            assertEquals(true, submissionServiceIntegrals.simpson(simpsonDataRequest));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Token exception");
        }
    }
}