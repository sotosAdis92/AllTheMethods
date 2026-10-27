package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.FivePointDerivativeRequest;
import com.example.allTheMethods.dto.request.RichardsonRequest;
import com.example.allTheMethods.dto.request.ThreePointDerivativeRequest;
import com.example.allTheMethods.service.imp.DerivativesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/submissions")
public class DerivativeSubmissionController {
    private static final Logger log = LoggerFactory.getLogger(DerivativeSubmissionController.class);
    private final DerivativesService submissionServiceDerivatives;
    public DerivativeSubmissionController(DerivativesService submissionServiceDerivatives){
        this.submissionServiceDerivatives = submissionServiceDerivatives;
    }

    @PostMapping("/threePointsDer")
    public ResponseEntity<?> threePointDerivative(@RequestBody ThreePointDerivativeRequest threePointDerivativeRequest){
        log.debug("Getting response from three point derivative problem");
        return new ResponseEntity<>(submissionServiceDerivatives.threePointDerivative(threePointDerivativeRequest), HttpStatus.OK);
    }

    @PostMapping("/fivePointsDer")
    public ResponseEntity<?> fivePointDerivative(@RequestBody FivePointDerivativeRequest fivePointDerivativeRequest){
        log.debug("Getting response from five point derivative problem");
        return new ResponseEntity<>(submissionServiceDerivatives.FivePointDerivative(fivePointDerivativeRequest), HttpStatus.OK);
    }

    @PostMapping("/richardson")
    public ResponseEntity<?> richardson(@RequestBody RichardsonRequest richardsonRequest){
        log.debug("Getting response from simpson extrapolation problem");
        return new ResponseEntity<>(submissionServiceDerivatives.richardson(richardsonRequest), HttpStatus.OK);
    }
}
