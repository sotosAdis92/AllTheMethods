package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/problems")
public class ProblemController {
    private ProblemService problemService;
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping
    public ResponseEntity<ProblemDto> createProblem(@RequestBody ProblemDto problemDto){
       ProblemDto savedProblem =  problemService.createProblem(problemDto);
       return new ResponseEntity<>(savedProblem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProblemDto> getProblemById(@PathVariable("id") Long id){
        ProblemDto problemDto = problemService.getProblemById(id);
        return ResponseEntity.ok(problemDto);
    }

    @GetMapping
    public ResponseEntity<List<ProblemDto>> getAllProblems(){
        List<ProblemDto> problems = problemService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProblemDto> updateProblem(@PathVariable("id") Long id, @RequestBody ProblemDto updateProblemDto){
        ProblemDto problemDto = problemService.updateProblem(id, updateProblemDto);
        return ResponseEntity.ok(problemDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProblem(@PathVariable Long id){
        problemService.deleteProblem(id);
        return ResponseEntity.ok("Deleted problem");
    }
}
