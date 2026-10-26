package com.example.allTheMethods.controllers;


import com.example.allTheMethods.dto.request.CreateProblemRequest;
import com.example.allTheMethods.dto.request.UpdateProblemRequest;
import com.example.allTheMethods.dto.response.ProblemResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/problems")
public class ProblemController {
    private ProblemService problemService;
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProblemResponse> createProblem(@Valid @RequestBody CreateProblemRequest problemDto){
        ProblemResponse savedProblem =  problemService.createProblem(problemDto);
        return new ResponseEntity<>(savedProblem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProblemResponse> getProblemById(@PathVariable("id") int id){
        ProblemResponse problemDto = problemService.getProblemById(id);
        return ResponseEntity.ok(problemDto);
    }

    @GetMapping
    public ResponseEntity<List<ProblemResponse>> getAllProblems(){
        List<ProblemResponse> problems = problemService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProblemResponse> updateProblem(@Valid @PathVariable("id") Long id, @RequestBody UpdateProblemRequest updateProblemDto){
        ProblemResponse problemDto = problemService.updateProblem(id, updateProblemDto);
        return ResponseEntity.ok(problemDto);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProblem(@PathVariable Long id){
        problemService.deleteProblem(id);
        return ResponseEntity.ok("Deleted problem");
    }

    @GetMapping("categories/{category}")
    public ResponseEntity<List<ProblemResponse>> getProblemsByCategory(@PathVariable("category") String category){
        List<ProblemResponse> problemDtos = problemService.getProblemsByCategory(category);
        return ResponseEntity.ok(problemDtos);
    }

    @GetMapping("difficulty/{difficulty}")
    public ResponseEntity<List<ProblemResponse>> getProblemsByDifficulty(@PathVariable("difficulty") String difficulty){
        List<ProblemResponse> problemDtos = problemService.getProblemsByDifficulty(difficulty);
        return ResponseEntity.ok(problemDtos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProblemResponse>> getProblemsByCategoryAndDifficulty(@RequestParam(required = false) List<String> categories, @RequestParam(required = false) List<String> difficulties){
        List<ProblemResponse> problemDtos = problemService.getProblemsByCategoryOrDifficulty(categories,difficulties);
        return ResponseEntity.ok(problemDtos);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllTheExistingProblems(){
        long count = problemService.countAllTheExistingProblems();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/types/{type}")
    public ResponseEntity<List<ProblemResponse>> getProblemsByProblemType(@PathVariable("type") String problemType){
        List<ProblemResponse> problemResponses = problemService.getProblemsByProblemType(problemType);
        return ResponseEntity.ok((problemResponses));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Problem>> getProblems(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
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
