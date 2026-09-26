package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.*;
import com.example.allTheMethods.service.SubmissionServicePolynomials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/submissions")
public class PolynomialRootsSubmissionsController {
    @Autowired
    private SubmissionServicePolynomials submissionServicePolynomials;
    public PolynomialRootsSubmissionsController(SubmissionServicePolynomials submissionServicePolynomials){
        this.submissionServicePolynomials = submissionServicePolynomials;
    }

    @PostMapping("/bisection")
    public ResponseEntity<?> bisection(@RequestBody BisectionDataDto bisectionDataDto){
        return new ResponseEntity<>(submissionServicePolynomials.bisection(bisectionDataDto), HttpStatus.OK);
    }

    @PostMapping("/regulaFalsi")
    public ResponseEntity<?> regulaFalsi(@RequestBody RegulaFalsiDataDto regulaFalsiDataDto){
        return new ResponseEntity<>(submissionServicePolynomials.regulaFalsi(regulaFalsiDataDto), HttpStatus.OK);
    }

    @PostMapping("/newtonRaphson")
    public ResponseEntity<?> newtonRaphson(@RequestBody NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        return new ResponseEntity<>(submissionServicePolynomials.newtonRaphson(newtonRaphsonDataDto), HttpStatus.OK);
    }

    @PostMapping("/diakritiNewtonRaphson")
    public ResponseEntity<?> diakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto){
        return new ResponseEntity<>(submissionServicePolynomials.diakritiNewtonRaphson(diakritiNewtonRaphsonDto), HttpStatus.OK);
    }

    @PostMapping("/fixedPoint")
    public ResponseEntity<?> fixedPointMethod(@RequestBody FixedPointDto fixedPointDto){
        return new ResponseEntity<>(submissionServicePolynomials.fixedPointMethod(fixedPointDto), HttpStatus.OK);
    }

}
