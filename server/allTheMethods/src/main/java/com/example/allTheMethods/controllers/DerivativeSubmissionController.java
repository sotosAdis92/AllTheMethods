package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.FivePointDerivativeDto;
import com.example.allTheMethods.dto.request.RichardsonDataDto;
import com.example.allTheMethods.dto.request.ThreePointDerivativeDto;
import com.example.allTheMethods.service.SubmissionServiceDerivatives;
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
    private SubmissionServiceDerivatives submissionServiceDerivatives;
    public DerivativeSubmissionController(SubmissionServiceDerivatives submissionServiceDerivatives){
        this.submissionServiceDerivatives = submissionServiceDerivatives;
    }

    @PostMapping("/threePointsDer")
    public ResponseEntity<?> threePointDerivative(@RequestBody ThreePointDerivativeDto threePointDerivativeDto){
        log.debug("Getting response from three point derivative problem");
        return new ResponseEntity<>(submissionServiceDerivatives.threePointDerivative(threePointDerivativeDto), HttpStatus.OK);
    }

    @PostMapping("/fivePointsDer")
    public ResponseEntity<?> fivePointDerivative(@RequestBody FivePointDerivativeDto fivePointDerivativeDto){
        log.debug("Getting response from five point derivative problem");
        return new ResponseEntity<>(submissionServiceDerivatives.FivePointDerivative(fivePointDerivativeDto), HttpStatus.OK);
    }

    @PostMapping("/richardson")
    public ResponseEntity<?> richardson(@RequestBody RichardsonDataDto richardsonDataDto){
        log.debug("Getting response from simpson extrapolation problem");
        return new ResponseEntity<>(submissionServiceDerivatives.richardson(richardsonDataDto), HttpStatus.OK);
    }
}
