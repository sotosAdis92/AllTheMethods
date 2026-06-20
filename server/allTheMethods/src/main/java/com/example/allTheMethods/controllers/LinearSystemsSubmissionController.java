package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.GerschgorinCirclesDto;
import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class LinearSystemsSubmissionController {
    private SubmissionServiceLinearSystems submissionServiceLinearSystems;
    public LinearSystemsSubmissionController(SubmissionServiceLinearSystems submissionServiceLinearSystems){
        this.submissionServiceLinearSystems = submissionServiceLinearSystems;
    }
    @PostMapping("/gerCircles")
    public boolean checkGerschgorinCircleData(@RequestBody GerschgorinCirclesDto gerschgorinCirclesDto){
        boolean flag;
        flag = submissionServiceLinearSystems.checkGerschgorinCircleData(gerschgorinCirclesDto);
        return flag;
    }
}
