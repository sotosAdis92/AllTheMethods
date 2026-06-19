package com.example.allTheMethods.service;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;

public interface SubmissionServicePolynomials {
    boolean checkDataBisection(BisectionDataDto bisectionDataDto);
    boolean checkDataRegulaFalsi(RegulaFalsiDataDto regulaFalsiDataDto);
    boolean checkDataNewtonRaphson(NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException;
    boolean checkDataDiakritiNewtonRaphson(DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto);
    boolean checkDataFixedPointMethod(FixedPointDto fixedPointDto);
}
