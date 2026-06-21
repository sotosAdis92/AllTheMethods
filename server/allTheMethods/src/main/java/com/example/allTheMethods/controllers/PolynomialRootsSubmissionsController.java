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
        return submissionServicePolynomials.checkDataBisection(bisectionDataDto);
    }

    @PostMapping("/regulaFalsi")
    public boolean checkDataRegulaFalsi(@RequestBody RegulaFalsiDataDto regulaFalsiDataDto){
        return submissionServicePolynomials.checkDataRegulaFalsi(regulaFalsiDataDto);
    }

    @PostMapping("/newtonRaphson")
    public boolean checkDataNewtonRaphson(@RequestBody NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        return submissionServicePolynomials.checkDataNewtonRaphson(newtonRaphsonDataDto);
    }

    @PostMapping("/diakritiNewtonRaphson")
    public boolean chekcDataDiakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto){
        return submissionServicePolynomials.checkDataDiakritiNewtonRaphson(diakritiNewtonRaphsonDto);
    }

    @PostMapping("/fixedPoint")
    public boolean checkDataFixedPoint(@RequestBody FixedPointDto fixedPointDto){
        return submissionServicePolynomials.checkDataFixedPointMethod(fixedPointDto);
    }

}
