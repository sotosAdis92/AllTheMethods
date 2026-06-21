package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.SubmissionServicePolynomials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> checkDataBisection(@RequestBody BisectionDataDto bisectionDataDto){
        return new ResponseEntity<>(submissionServicePolynomials.checkDataBisection(bisectionDataDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/regulaFalsi")
    public ResponseEntity<?> checkDataRegulaFalsi(@RequestBody RegulaFalsiDataDto regulaFalsiDataDto){
        return new ResponseEntity<>(submissionServicePolynomials.checkDataRegulaFalsi(regulaFalsiDataDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/newtonRaphson")
    public ResponseEntity<?> checkDataNewtonRaphson(@RequestBody NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        return new ResponseEntity<>(submissionServicePolynomials.checkDataNewtonRaphson(newtonRaphsonDataDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/diakritiNewtonRaphson")
    public ResponseEntity<?> chekcDataDiakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto){
        return new ResponseEntity<>(submissionServicePolynomials.checkDataDiakritiNewtonRaphson(diakritiNewtonRaphsonDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/fixedPoint")
    public ResponseEntity<?> checkDataFixedPoint(@RequestBody FixedPointDto fixedPointDto){
        return new ResponseEntity<>(submissionServicePolynomials.checkDataFixedPointMethod(fixedPointDto), HttpStatus.ACCEPTED);
    }

}
