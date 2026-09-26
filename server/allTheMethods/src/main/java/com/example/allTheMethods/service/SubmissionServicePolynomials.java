package com.example.allTheMethods.service;
import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.*;

public interface SubmissionServicePolynomials {
    boolean bisection(BisectionDataDto bisectionDataDto);
    boolean regulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto);
    boolean newtonRaphson(NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException;
    boolean diakritiNewtonRaphson(DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto);
    boolean fixedPointMethod(FixedPointDto fixedPointDto);
}
