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
@RequestMapping("/api/submissions")
public class DerivativeSubmissionController {
    private static final Logger log = LoggerFactory.getLogger(DerivativeSubmissionController.class);
    private SubmissionServiceDerivatives submissionServiceDerivatives;
    public DerivativeSubmissionController(SubmissionServiceDerivatives submissionServiceDerivatives){
        this.submissionServiceDerivatives = submissionServiceDerivatives;
    }

    @PostMapping("/threePointsDer")
    public ResponseEntity<?> checkThreePointDerivativeData(@RequestBody ThreePointDerivativeDto threePointDerivativeDto){
        log.debug("Getting response from three point derivative problem");
        return new ResponseEntity<>(submissionServiceDerivatives.checkThreePointDerivativeData(threePointDerivativeDto), HttpStatus.OK);
    }

    @PostMapping("/fivePointsDer")
    public ResponseEntity<?> checkFivePointDerivativeData(@RequestBody FivePointDerivativeDto fivePointDerivativeDto){
        log.debug("Getting response from five point derivative problem");
        return new ResponseEntity<>(submissionServiceDerivatives.checkFivePointDerivativeData(fivePointDerivativeDto), HttpStatus.OK);
    }

    @PostMapping("/richardson")
    public ResponseEntity<?> checkRichardsonData(@RequestBody RichardsonDataDto richardsonDataDto){
        log.debug("Getting response from simpson extrapolation problem");
        return new ResponseEntity<>(submissionServiceDerivatives.checkRichardsonData(richardsonDataDto), HttpStatus.OK);
    }
}
