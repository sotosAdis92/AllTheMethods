package com.example.allTheMethods.controllers;


import com.example.allTheMethods.dto.request.CreateProblemRequestDto;
import com.example.allTheMethods.dto.request.UpdateProblemRequestDto;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.service.ProblemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<ProblemResponseDto> createProblem(@RequestBody CreateProblemRequestDto problemDto){
        ProblemResponseDto savedProblem =  problemService.createProblem(problemDto);
        return new ResponseEntity<>(savedProblem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProblemResponseDto> getProblemById(@PathVariable("id") int id){
        ProblemResponseDto problemDto = problemService.getProblemById(id);
        return ResponseEntity.ok(problemDto);
    }

    @GetMapping
    public ResponseEntity<List<ProblemResponseDto>> getAllProblems(){
        List<ProblemResponseDto> problems = problemService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProblemResponseDto> updateProblem(@PathVariable("id") Long id, @RequestBody UpdateProblemRequestDto updateProblemDto){
        ProblemResponseDto problemDto = problemService.updateProblem(id, updateProblemDto);
        return ResponseEntity.ok(problemDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProblem(@PathVariable Long id){
        problemService.deleteProblem(id);
        return ResponseEntity.ok("Deleted problem");
    }

    @GetMapping("categories/{category}")
    public ResponseEntity<List<ProblemResponseDto>> getProblemsByCategory(@PathVariable("category") String category){
        List<ProblemResponseDto> problemDtos = problemService.getProblemsByCategory(category);
        return ResponseEntity.ok(problemDtos);
    }

    @GetMapping("difficulty/{difficulty}")
    public ResponseEntity<List<ProblemResponseDto>> getProblemsByDifficulty(@PathVariable("difficulty") String difficulty){
        List<ProblemResponseDto> problemDtos = problemService.getProblemsByDifficulty(difficulty);
        return ResponseEntity.ok(problemDtos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProblemResponseDto>> getProblemsByCategoryAndDifficulty(@RequestParam(required = false) List<String> categories, @RequestParam(required = false) List<String> difficulties){
        List<ProblemResponseDto> problemDtos = problemService.getProblemsByCategoryOrDifficulty(categories,difficulties);
        return ResponseEntity.ok(problemDtos);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllTheExistingProblems(){
        long count = problemService.countAllTheExistingProblems();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Problem>> getProblems(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDir
    ){
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("ASC")){
            sort = Sort.by(sortBy).ascending();
        }else{
            sort = Sort.by(sortBy).descending();
        }
        Page<Problem> responseDtos = problemService.getAllProblemsPaged(PageRequest.of(pageNo-1,pageSize,sort));
        return ResponseEntity.ok(responseDtos);
    }

}
