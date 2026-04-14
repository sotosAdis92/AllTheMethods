package com.example.allTheMethods.controllers;

import com.example.allTheMethods.ast.TokenizerException;
import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.service.SubmmisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private SubmmisionService submmisionService;

    public SubmissionController(SubmmisionService submmisionService) {
        this.submmisionService = submmisionService;
    }

    @PostMapping
    public ResponseEntity<SubmissionDto> createSubmission(@RequestBody SubmissionDto submissionDto){
        SubmissionDto submission = submmisionService.createSubmission(submissionDto);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    @PostMapping("/data")
    public boolean checkDataBisection(@RequestBody BisectionDataDto bisectionDataDto){
        boolean flag;
        flag =  submmisionService.checkDataBisection(bisectionDataDto);
        return flag;
    }

    @PostMapping("/regulaFalsi")
    public boolean checkDataRegulaFalsi(@RequestBody RegulaFalsiDataDto regulaFalsiDataDto){
        boolean flag;
        flag = submmisionService.checkDataRegulaFalsi(regulaFalsiDataDto);
        return flag;
    }

    @PostMapping("/newtonRaphson")
    public boolean checkDataNewtonRaphson(@RequestBody NewtonRaphsonDataDto newtonRaphsonDataDto) throws TokenizerException {
        boolean flag;
        flag = submmisionService.checkDataNewtonRaphson(newtonRaphsonDataDto);
        return flag;
    }

    @PostMapping("/diakritiNewtonRaphson")
    public boolean chekcDataDiakritiNewtonRaphson(@RequestBody DiakritiNewtonRaphsonDto diakritiNewtonRaphsonDto){
        boolean flag;
        flag = submmisionService.chekcDataDiakritiNewtonRaphson(diakritiNewtonRaphsonDto);
        return flag;
    }

}
