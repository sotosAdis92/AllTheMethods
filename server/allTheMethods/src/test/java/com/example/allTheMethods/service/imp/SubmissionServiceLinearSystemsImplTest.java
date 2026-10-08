package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.LinearSystemsDataDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<Double> row0 = new ArrayList<>();
        row0.add(1.0);
        row0.add(2.0);
        row0.add(3.0);

        List<Double> row1 = new ArrayList<>();
        row0.add(4.0);
        row0.add(5.0);
        row0.add(6.0);

        List<Double> row2 = new ArrayList<>();
        row0.add(7.0);
        row0.add(8.0);
        row0.add(9.0);

        List<List<Double>> matrix = new ArrayList<List<Double>>();
        matrix.add(row0);
        matrix.add(row1);
        matrix.add(row2);

        LinearSystemsDataDto linearSystemsDataDto = new LinearSystemsDataDto(inputs,matrix,variables,equals);
        try{
            assertEquals(true, submissionServiceLinearSystems.gershgorinCirclesAlgorithm(linearSystemsDataDto));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Token exception");
        }

    }

}