package com.example.allTheMethods.controllers;

import com.example.allTheMethods.service.SubmissionServiceLinearSystems;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class LinearSystemsSubmissionController {
    private SubmissionServiceLinearSystems submissionServiceLinearSystems;

}
