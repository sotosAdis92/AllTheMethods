package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.LinearSystemsDataDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionServiceLinearSystemsImplTest {

    @Test
    public void gershgorinCirclesTest(){
        SubmissionServiceLinearSystemsImpl submissionServiceLinearSystems = new SubmissionServiceLinearSystemsImpl();
        List<Double> inputs = new ArrayList<>();
        List<Optional<String>> variables = new ArrayList<>();
        List<Optional<Double>> equals = new ArrayList<>();
        inputs.add(-4.0);
        inputs.add(6.0);
        inputs.add(-5.0);
        inputs.add(15.0);
        inputs.add(0.0);
        inputs.add(18.0);

        double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        LinearSystemsDataDto linearSystemsDataDto = new LinearSystemsDataDto(inputs,matrix,variables,equals);
        try{
            assertEquals(true, submissionServiceLinearSystems.gershgorinCirclesAlgorithm(linearSystemsDataDto));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Token exception");
        }

    }

}