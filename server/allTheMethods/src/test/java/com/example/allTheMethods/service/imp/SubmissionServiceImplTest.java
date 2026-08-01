package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.NewtonRaphsonDataDto;
import com.example.allTheMethods.utils.MethodUtils;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionServiceImplTest {
    //@Test Annotation kanei thn methodo test methodo
    //To Framework ths Junit automatos trexei ola ta @Test methods
    //Xreiazetai to import epano apo to jupiter api
    //Ta @Test methods den xreiazontai access identifier, mporoun na einai sketa, public, private h protected
    @Test
    public void xSquaredFirstSimpleDerivativeTest(){
        MethodUtils ssi = new MethodUtils();
        try{
            assertEquals(4,ssi.fprime(2,"x^2"));
        } catch (TokenizerException tokenizerException){
            System.out.println("Token Exception");
        }
    }

    @Test
    public void firstDegreePolynomialDerivativeTest(){
        MethodUtils ssi = new MethodUtils();
        try{
            assertEquals(1, ssi.fprime(4,"2x-x"));
        } catch (TokenizerException tokenizerException){
            System.out.println("Token Exception");
        }
    }

    @Test
    public void firstDescreteFprimeTest(){
        MethodUtils ssi = new MethodUtils();
        assertEquals(2.100,ssi.DiakritiFprime(1,0.1,"x^2-2"));
    }

    @Test
    public void TestingNewtonRaphsonMethod(){
        MethodUtils ssi = new MethodUtils();
        NewtonRaphsonDataDto newtonRaphsonDataDto = new NewtonRaphsonDataDto();
        List<Double> testingInputs = new ArrayList<>();
        testingInputs.add(1.5);
        newtonRaphsonDataDto.setInp(testingInputs);
        newtonRaphsonDataDto.setXo(1);
        newtonRaphsonDataDto.setIterations(1);
        newtonRaphsonDataDto.setProblemString("x^2-2");
       // try{
        //    assertEquals(true, ssi.checkDataNewtonRaphson(newtonRaphsonDataDto));
      //  } catch (TokenizerException tokenizerException){
       //     System.out.println("Token exception");
      //  }

    }

}