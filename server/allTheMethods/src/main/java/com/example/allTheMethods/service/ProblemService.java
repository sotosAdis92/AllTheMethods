package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.CreateProblemRequest;
import com.example.allTheMethods.dto.request.UpdateProblemRequest;
import com.example.allTheMethods.dto.response.ProblemResponse;
import com.example.allTheMethods.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface ProblemService {
    ProblemResponse createProblem(CreateProblemRequest problemDto);
    ProblemResponse getProblemById(int id);
    List<ProblemResponse> getAllProblems();
    ProblemResponse updateProblem(Long id, UpdateProblemRequest updatedProblem);
    void deleteProblem(Long id);
    List<ProblemResponse> getProblemsByCategory(String category);
    List<ProblemResponse> getProblemsByDifficulty(String difficulty);
    List<ProblemResponse> getProblemsByCategoryOrDifficulty(List<String> categories, List<String> difficulties);
    long countAllTheExistingProblems();
    Page<Problem> getAllProblemsPaged(Pageable pageable);
    List<ProblemResponse> getProblemsByProblemType(String problemType);
}
