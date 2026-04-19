package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.SubmissionServiceDerivatives;
import com.example.allTheMethods.service.SubmissionServiceDifferentialEquations;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import com.example.allTheMethods.service.SubmmisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private SubmmisionService submmisionService;
    private SubmissionServiceIntegrals submissionServiceIntegrals;
    private SubmissionServiceDerivatives submissionServiceDerivatives;
    private SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations;

    public SubmissionController(SubmmisionService submmisionService, SubmissionServiceIntegrals submissionServiceIntegrals, SubmissionServiceDerivatives submissionServiceDerivatives, SubmissionServiceDifferentialEquations submissionServiceDifferentialEquations) {
        this.submmisionService = submmisionService;
        this.submissionServiceIntegrals = submissionServiceIntegrals;
        this.submissionServiceDerivatives = submissionServiceDerivatives;
        this.submissionServiceDifferentialEquations = submissionServiceDifferentialEquations;
    }

    @PostMapping
    public ResponseEntity<SubmissionDto> createSubmission(@RequestBody SubmissionDto submissionDto){
        SubmissionDto submission = submmisionService.createSubmission(submissionDto);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    @PostMapping("/data")
    public boolean checkDataBisection(@RequestBody BisectionDataDto bisectionDataDto){
        boolean flag;
        flag =  submmisionService.checkDataBisection(bisectionDataDto);
        return flag;
    }

    @PostMapping("/regulaFalsi")
    public boolean checkDataRegulaFalsi(@RequestBody RegulaFalsiDataDto regulaFalsiDataDto){
        boolean flag;
        flag = submmisionService.checkDataRegulaFalsi(regulaFalsiDataDto);
        return flag;
    }

    @PostMapping("/newtonRaphson")
    public boolean checkDataNewtonRaphson(@RequestBody NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        boolean flag;
        flag = submmisionService.checkDataNewtonRaphson(newtonRaphsonDataDto);
        return flag;
    }

    @PostMapping("/diakritiNewtonRaphson")
    public boolean chekcDataDiakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto){
        boolean flag;
        flag = submmisionService.checkDataDiakritiNewtonRaphson(diakritiNewtonRaphsonDto);
        return flag;
    }

    @PostMapping("/fixedPoint")
    public boolean checkDataFixedPoint(@RequestBody FixedPointDto fixedPointDto){
        boolean flag;
        flag = submmisionService.checkDataFixedPointMethod(fixedPointDto);
        return flag;
    }

    @PostMapping("/trapezodialRule")
    public boolean checkTrapezodialRuleData(@RequestBody TrapezodialRuleDataDto trapezodialRuleDataDto){
        boolean flag;
        flag = submissionServiceIntegrals.checkTrapezodialRuleData(trapezodialRuleDataDto);
        return flag;
    }

    @PostMapping("/simpson")
    public boolean checkSimpsonData(@RequestBody SimpsonDataDto simpsonDataDto){
        boolean flag;
        flag = submissionServiceIntegrals.checkSimpsonData(simpsonDataDto);
        return flag;
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

    @PostMapping("/rungeKutta")
    public boolean checkRungeKuttaData(@RequestBody RungeKuttaDataDto rungeKuttaDataDto){
        boolean flag;
        flag = submissionServiceDifferentialEquations.checkRungeKuttaData(rungeKuttaDataDto);
        return flag;
    }

    @PostMapping("/improvedEuler")
    public boolean checkImprovedEulerData(@RequestBody ImprovedEulerDto improvedEulerDto){
        boolean flag;
        flag = submissionServiceDifferentialEquations.checkImprovedEulerData(improvedEulerDto);
        return flag;
    }
}
