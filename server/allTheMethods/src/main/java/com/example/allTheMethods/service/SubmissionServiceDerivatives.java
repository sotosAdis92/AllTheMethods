package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.FivePointDerivativeDto;
import com.example.allTheMethods.dto.request.RichardsonDataDto;
import com.example.allTheMethods.dto.request.ThreePointDerivativeDto;


public interface SubmissionServiceDerivatives {
    boolean threePointDerivative(ThreePointDerivativeDto threePointDerivativeDto);
    boolean FivePointDerivative(FivePointDerivativeDto fivePointDerivativeDto);
    boolean richardson(RichardsonDataDto richardsonDataDto);
}
