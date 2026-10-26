package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.FivePointDerivativeRequest;
import com.example.allTheMethods.dto.request.RichardsonRequest;
import com.example.allTheMethods.dto.request.ThreePointDerivativeRequest;


public interface SubmissionServiceDerivatives {
    boolean threePointDerivative(ThreePointDerivativeRequest threePointDerivativeRequest);
    boolean FivePointDerivative(FivePointDerivativeRequest fivePointDerivativeRequest);
    boolean richardson(RichardsonRequest richardsonRequest);
}
