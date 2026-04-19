package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.FivePointDerivativeDto;
import com.example.allTheMethods.dto.RichardsonDataDto;
import com.example.allTheMethods.dto.ThreePointDerivativeDto;
import org.springframework.stereotype.Service;


public interface SubmissionServiceDerivatives {
    boolean checkThreePointDerivativeData(ThreePointDerivativeDto threePointDerivativeDto);
    boolean checkFivePointDerivativeData(FivePointDerivativeDto fivePointDerivativeDto);
    boolean checkRichardsonData(RichardsonDataDto richardsonDataDto);
}
