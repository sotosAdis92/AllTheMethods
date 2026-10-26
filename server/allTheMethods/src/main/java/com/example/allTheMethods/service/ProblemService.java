package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateProblemRequest;
import com.example.allTheMethods.dto.request.UpdateProblemRequest;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface ProblemService {
    ProblemResponseDto createProblem(CreateProblemRequest problemDto);
    ProblemResponseDto getProblemById(int id);
    List<ProblemResponseDto> getAllProblems();
    ProblemResponseDto updateProblem(Long id, UpdateProblemRequest updatedProblem);
    void deleteProblem(Long id);
    List<ProblemResponseDto> getProblemsByCategory(String category);
    List<ProblemResponseDto> getProblemsByDifficulty(String difficulty);
    List<ProblemResponseDto> getProblemsByCategoryOrDifficulty(List<String> categories, List<String> difficulties);
    long countAllTheExistingProblems();
    Page<Problem> getAllProblemsPaged(Pageable pageable);
    List<ProblemResponseDto> getProblemsByProblemType(String problemType);
}
