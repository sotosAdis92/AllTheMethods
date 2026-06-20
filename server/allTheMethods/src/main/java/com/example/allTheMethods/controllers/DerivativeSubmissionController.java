package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.FivePointDerivativeDto;
import com.example.allTheMethods.dto.RichardsonDataDto;
import com.example.allTheMethods.dto.ThreePointDerivativeDto;
import com.example.allTheMethods.service.SubmissionServiceDerivatives;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class DerivativeSubmissionController {
    private SubmissionServiceDerivatives submissionServiceDerivatives;
    public DerivativeSubmissionController(SubmissionServiceDerivatives submissionServiceDerivatives){
        this.submissionServiceDerivatives = submissionServiceDerivatives;
    }

    @PostMapping("/threePointsDer")
    public boolean checkThreePointDerivativeData(@RequestBody ThreePointDerivativeDto threePointDerivativeDto){
        boolean flag;
        flag = submissionServiceDerivatives.checkThreePointDerivativeData(threePointDerivativeDto);
        return flag;
    }

    @PostMapping("/fivePointsDer")
    public boolean checkFivePointDerivativeData(@RequestBody FivePointDerivativeDto fivePointDerivativeDto){
        boolean flag;
        flag = submissionServiceDerivatives.checkFivePointDerivativeData(fivePointDerivativeDto);
        return flag;
    }

    @PostMapping("/richardson")
    public boolean checkRichardsonData(@RequestBody RichardsonDataDto richardsonDataDto){
        boolean flag;
        flag = submissionServiceDerivatives.checkRichardsonData(richardsonDataDto);
        return flag;
    }
}
