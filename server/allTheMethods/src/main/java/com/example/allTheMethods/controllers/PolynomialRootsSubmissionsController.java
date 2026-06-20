package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.SubmissionServicePolynomials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class PolynomialRootsSubmissionsController {
    @Autowired
    private SubmissionServicePolynomials submissionServicePolynomials;
    public PolynomialRootsSubmissionsController(SubmissionServicePolynomials submissionServicePolynomials){
        this.submissionServicePolynomials = submissionServicePolynomials;
    }

    @PostMapping("/bisection")
    public boolean checkDataBisection(@RequestBody BisectionDataDto bisectionDataDto){
        boolean flag;
        flag =  submissionServicePolynomials.checkDataBisection(bisectionDataDto);
        return flag;
    }

    @PostMapping("/regulaFalsi")
    public boolean checkDataRegulaFalsi(@RequestBody RegulaFalsiDataDto regulaFalsiDataDto){
        boolean flag;
        flag = submissionServicePolynomials.checkDataRegulaFalsi(regulaFalsiDataDto);
        return flag;
    }

    @PostMapping("/newtonRaphson")
    public boolean checkDataNewtonRaphson(@RequestBody NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        boolean flag;
        flag = submissionServicePolynomials.checkDataNewtonRaphson(newtonRaphsonDataDto);
        return flag;
    }

    @PostMapping("/diakritiNewtonRaphson")
    public boolean chekcDataDiakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto){
        boolean flag;
        flag = submissionServicePolynomials.checkDataDiakritiNewtonRaphson(diakritiNewtonRaphsonDto);
        return flag;
    }

    @PostMapping("/fixedPoint")
    public boolean checkDataFixedPoint(@RequestBody FixedPointDto fixedPointDto){
        boolean flag;
        flag = submissionServicePolynomials.checkDataFixedPointMethod(fixedPointDto);
        return flag;
    }

}
