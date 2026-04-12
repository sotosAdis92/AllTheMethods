package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.TokenizerException;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionServiceImplTest {

    @Test
    void xSquaredFirstSimpleDerivativeTest(){
        SubmissionServiceImpl ssi = new SubmissionServiceImpl();
        try{
            assertEquals(4,ssi.fprime(2,"x^2"));
        } catch (TokenizerException tokenizerException){
            System.out.println("Token Exception");
        }
    }

    @Test
    void firstDegreePolynomialDerivativeTest(){
        SubmissionServiceImpl ssi = new SubmissionServiceImpl();
        try{
            assertEquals(1, ssi.fprime(4,"2x-x"));
        } catch (TokenizerException tokenizerException){
            System.out.println("Token Exception");
        }
    }

}