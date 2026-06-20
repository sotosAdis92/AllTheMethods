package com.example.allTheMethods.controllers;


import com.example.allTheMethods.dto.SimpsonDataDto;
import com.example.allTheMethods.dto.TrapezodialRuleDataDto;
import com.example.allTheMethods.service.SubmissionServiceIntegrals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class IntegralSubmissionController {
    private SubmissionServiceIntegrals submissionServiceIntegrals;
    public IntegralSubmissionController(SubmissionServiceIntegrals submissionServiceIntegrals){
        this.submissionServiceIntegrals = submissionServiceIntegrals;
    }

    @PostMapping("/trapezodialRule")
    public boolean checkTrapezodialRuleData(@RequestBody TrapezodialRuleDataDto trapezodialRuleDataDto){
        boolean flag;
        flag = submissionServiceIntegrals.checkTrapezodialRuleData(trapezodialRuleDataDto);
        return flag;
    }

    @PostMapping("/simpson")
    public boolean checkSimpsonData(@RequestBody SimpsonDataDto simpsonDataDto){
        boolean flag;
        flag = submissionServiceIntegrals.checkSimpsonData(simpsonDataDto);
        return flag;
    }

}
