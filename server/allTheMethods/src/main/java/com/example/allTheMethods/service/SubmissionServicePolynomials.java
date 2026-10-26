package com.example.allTheMethods.service;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.*;

public interface SubmissionServicePolynomials {
    boolean bisection(BisectionRequest bisectionRequest);
    boolean regulaFalsi(RegulaFalsiRequest regulaFalsiRequest);
    boolean newtonRaphson(NewtonRaphsonRequest newtonRaphsonRequest) throws TokenizerException;
    boolean diakritiNewtonRaphson(DiakritiNewtonRaphsonRequest diakritiNewtonRaphsonRequest);
    boolean fixedPointMethod(FixedPointRequest fixedPointRequest);
}
