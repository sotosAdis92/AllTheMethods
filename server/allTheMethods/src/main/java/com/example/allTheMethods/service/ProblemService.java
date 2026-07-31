package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.dto.request.CreateProblemRequestDto;
import com.example.allTheMethods.dto.response.ProblemResponseDto;

import java.util.List;


public interface ProblemService {
    ProblemResponseDto createProblem(CreateProblemRequestDto problemDto);
    ProblemResponseDto getProblemById(Long id);
    List<ProblemResponseDto> getAllProblems();
    ProblemResponseDto updateProblem(Long id, ProblemDto updatedProblem);
    void deleteProblem(Long id);
    List<ProblemResponseDto> getProblemsByCategory(String category);
    List<ProblemResponseDto> getProblemsByDifficulty(String difficulty);
    List<ProblemResponseDto> getProblemsByCategoryOrDifficulty(List<String> categories, List<String> difficulties);
    long countAllTheExistingProblems();
}
