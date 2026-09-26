package com.example.allTheMethods.controllers;


import com.example.allTheMethods.dto.request.SimpsonDataDto;
import com.example.allTheMethods.dto.request.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/submissions")
public class IntegralSubmissionController {
    private SubmissionServiceIntegrals submissionServiceIntegrals;
    public IntegralSubmissionController(SubmissionServiceIntegrals submissionServiceIntegrals){
        this.submissionServiceIntegrals = submissionServiceIntegrals;
    }

    @PostMapping("/trapezodialRule")
    public ResponseEntity<?> trapezodialRule(@RequestBody TrapezodialRuleDataDto trapezodialRuleDataDto){
        return new ResponseEntity<>(submissionServiceIntegrals.trapezodialRule(trapezodialRuleDataDto), HttpStatus.OK);

    }

    @PostMapping("/simpson")
    public ResponseEntity<?> simpson(@RequestBody SimpsonDataDto simpsonDataDto){
        return new ResponseEntity<>(submissionServiceIntegrals.simpson(simpsonDataDto), HttpStatus.OK);

    }

}
