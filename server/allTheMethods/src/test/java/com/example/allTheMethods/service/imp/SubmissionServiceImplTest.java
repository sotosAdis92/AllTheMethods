package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.ast.TokenizerException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SubmissionServiceImplTest {
    //@Test Annotation kanei thn methodo test methodo
    //To Framework ths Junit automatos trexei ola ta @Test methods
    //Xreiazetai to import epano apo to jupiter api
    //Ta @Test methods den xreiazontai access identifier, mporoun na einai sketa, public, private h protected
    @Test
    public void xSquaredFirstSimpleDerivativeTest(){
        SubmissionServiceImpl ssi = new SubmissionServiceImpl();
        try{
            assertEquals(4,ssi.fprime(2,"x^2"));
        } catch (TokenizerException tokenizerException){
            System.out.println("Token Exception");
        }
    }

    @Test
    public void firstDegreePolynomialDerivativeTest(){
        SubmissionServiceImpl ssi = new SubmissionServiceImpl();
        try{
            assertEquals(1, ssi.fprime(4,"2x-x"));
        } catch (TokenizerException tokenizerException){
            System.out.println("Token Exception");
        }
    }

}