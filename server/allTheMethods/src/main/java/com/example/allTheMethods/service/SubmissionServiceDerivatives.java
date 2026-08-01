package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.FivePointDerivativeDto;
import com.example.allTheMethods.dto.request.RichardsonDataDto;
import com.example.allTheMethods.dto.request.ThreePointDerivativeDto;


public interface SubmissionServiceDerivatives {
    boolean checkThreePointDerivativeData(ThreePointDerivativeDto threePointDerivativeDto);
    boolean checkFivePointDerivativeData(FivePointDerivativeDto fivePointDerivativeDto);
    boolean checkRichardsonData(RichardsonDataDto richardsonDataDto);
}
