package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.*;
import com.example.allTheMethods.service.UserProblemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user/problems")
public class UserProblemController {
    private final UserProblemService userProblemService;

    public UserProblemController(UserProblemService userProblemService) {
        this.userProblemService = userProblemService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserProblemResponse> saveUserProblem(@RequestBody SaveUserProblemRequestDto requestDto){
        UserProblemResponse userProblemDto = userProblemService.saveUserProblem(requestDto);
        return new ResponseEntity<>(userProblemDto, HttpStatus.CREATED);
    }

    @GetMapping("/myproblems/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Page<UserProblemResponse>> getMyProblems(
            @PathVariable("id") int id,
            @RequestParam(defaultValue = "1", required = false, name = "pageNo") int pageNo,
            @RequestParam(defaultValue = "10", required = false, name = "pageSize") int pageSize
    ){
        Page<UserProblemResponse> userProblems = userProblemService.getUserProblemsByUserId(id, PageRequest.of(pageNo-1,pageSize));
        return new ResponseEntity<>(userProblems, HttpStatus.OK);
    }

    @GetMapping("/check/{id}")
    public boolean checkIfUserSolvedAProblem(@PathVariable("id") int id){
        return userProblemService.checkIfUserSolvedAProblem(id);
    }

    @GetMapping("/difficulty/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<List<DifficultyStatsResponse>> getCountAllProblemsOfUserByDifficulty(@PathVariable("id") int id){
        List<DifficultyStatsResponse> count = userProblemService.countAllByUserAndProblemDifficulty(id);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<List<UserProblemStatsResponseDto>> countDistinctSolvedProblemsByDifficultyForUser(@PathVariable("id") int id){
        List<UserProblemStatsResponseDto> countDistinct = userProblemService.countDistinctSolvedProblemsByDifficultyForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/category/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<List<CategoryStatsResponseDto>> countDistinctSolvedProblemsByCategory(@PathVariable("id") int id){
        System.out.println(id);
        List<CategoryStatsResponseDto> countDistinct = userProblemService.countDistinctSolvedProblemsByCategoryForUser(id);
        return ResponseEntity.ok(countDistinct);
    }

    @GetMapping("/summary/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<SummaryResponseDto> getSummeryOfUser(@PathVariable("id") int id){
        SummaryResponseDto summery = userProblemService.countSummeryOfUser(id);
        return ResponseEntity.ok(summery);
    }

}
