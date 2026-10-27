package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.SimpsonDataRequest;
import com.example.allTheMethods.dto.request.TrapezoidalRuleRequest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegralsServiceTest {
    @Test
    public void testingTrapezodalRuleTestCase() throws TokenizerException{
        IntegralsService submissionServiceIntegrals = new IntegralsService();
        TrapezoidalRuleRequest trpdto = new TrapezoidalRuleRequest();
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
    public void testTrapezoidalRuleCaseNegativeInput() throws TokenizerException{
        IntegralsService integralsService = new IntegralsService();
        List<Double> testingInputs = new ArrayList<>();
        testingInputs.add(-1.0);
        testingInputs.add(0.7);
        testingInputs.add(0.00023);
        TrapezoidalRuleRequest trapezoidalRuleRequest = new TrapezoidalRuleRequest(testingInputs,"x-2",3,6,1);
        try{
            assertEquals(true, integralsService.trapezodialRule(trapezoidalRuleRequest));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Token Exception");
        }
    }

    @Test
    public void testSimposonRuleTestCase() throws TokenizerException{
        IntegralsService submissionServiceIntegrals = new IntegralsService();
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