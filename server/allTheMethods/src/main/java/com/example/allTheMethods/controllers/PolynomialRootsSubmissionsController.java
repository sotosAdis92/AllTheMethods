package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.request.*;
import com.example.allTheMethods.service.imp.PolynomialsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/submissions")
public class PolynomialRootsSubmissionsController {
    private final PolynomialsService submissionServicePolynomials;
    public PolynomialRootsSubmissionsController(PolynomialsService submissionServicePolynomials){
        this.submissionServicePolynomials = submissionServicePolynomials;
    }

    @PostMapping("/bisection")
    public ResponseEntity<Boolean> bisection(@RequestBody BisectionRequest bisectionRequest){
        return new ResponseEntity<>(submissionServicePolynomials.bisection(bisectionRequest), HttpStatus.OK);
    }

    @PostMapping("/regulaFalsi")
    public ResponseEntity<Boolean> regulaFalsi(@RequestBody RegulaFalsiRequest regulaFalsiRequest){
        return new ResponseEntity<>(submissionServicePolynomials.regulaFalsi(regulaFalsiRequest), HttpStatus.OK);
    }

    @PostMapping("/newtonRaphson")
    public ResponseEntity<Boolean> newtonRaphson(@RequestBody NewtonRaphsonRequest newtonRaphsonRequest) throws TokenizerException {
        return new ResponseEntity<>(submissionServicePolynomials.newtonRaphson(newtonRaphsonRequest), HttpStatus.OK);
    }

    @PostMapping("/diakritiNewtonRaphson")
    public ResponseEntity<Boolean> diakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonRequest diakritiNewtonRaphsonRequest){
        return new ResponseEntity<>(submissionServicePolynomials.diakritiNewtonRaphson(diakritiNewtonRaphsonRequest), HttpStatus.OK);
    }

    @PostMapping("/fixedPoint")
    public ResponseEntity<Boolean> fixedPointMethod(@RequestBody FixedPointRequest fixedPointRequest){
        return new ResponseEntity<>(submissionServicePolynomials.fixedPointMethod(fixedPointRequest), HttpStatus.OK);
    }

}
