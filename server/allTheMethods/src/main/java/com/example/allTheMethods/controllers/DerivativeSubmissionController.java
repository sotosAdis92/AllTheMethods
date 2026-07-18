package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.FivePointDerivativeDto;
import com.example.allTheMethods.dto.RichardsonDataDto;
import com.example.allTheMethods.dto.ThreePointDerivativeDto;
import com.example.allTheMethods.service.SubmissionServiceDerivatives;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class DerivativeSubmissionController {
    private SubmissionServiceDerivatives submissionServiceDerivatives;

    @PostMapping("/threePointsDer")
    public ResponseEntity<?> checkThreePointDerivativeData(@RequestBody ThreePointDerivativeDto threePointDerivativeDto){
        return new ResponseEntity<>(submissionServiceDerivatives.checkThreePointDerivativeData(threePointDerivativeDto), HttpStatus.OK);
    }

    @PostMapping("/fivePointsDer")
    public ResponseEntity<?> checkFivePointDerivativeData(@RequestBody FivePointDerivativeDto fivePointDerivativeDto){
        return new ResponseEntity<>(submissionServiceDerivatives.checkFivePointDerivativeData(fivePointDerivativeDto), HttpStatus.OK);
    }

    @PostMapping("/richardson")
    public ResponseEntity<?> checkRichardsonData(@RequestBody RichardsonDataDto richardsonDataDto){
        return new ResponseEntity<>(submissionServiceDerivatives.checkRichardsonData(richardsonDataDto), HttpStatus.OK);
    }
}
