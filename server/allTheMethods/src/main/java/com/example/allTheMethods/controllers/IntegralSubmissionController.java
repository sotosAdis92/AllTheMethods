package com.example.allTheMethods.controllers;


import com.example.allTheMethods.dto.SimpsonDataDto;
import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class IntegralSubmissionController {
    private SubmissionServiceIntegrals submissionServiceIntegrals;

    @PostMapping("/trapezodialRule")
    public ResponseEntity<?> checkTrapezodialRuleData(@RequestBody TrapezodialRuleDataDto trapezodialRuleDataDto){
        return new ResponseEntity<>(submissionServiceIntegrals.checkTrapezodialRuleData(trapezodialRuleDataDto), HttpStatus.OK);

    }

    @PostMapping("/simpson")
    public ResponseEntity<?> checkSimpsonData(@RequestBody SimpsonDataDto simpsonDataDto){
        return new ResponseEntity<>(submissionServiceIntegrals.checkSimpsonData(simpsonDataDto), HttpStatus.OK);

    }

}
