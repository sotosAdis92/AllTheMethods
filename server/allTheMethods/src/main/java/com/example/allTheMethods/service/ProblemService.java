package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.ProblemDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProblemService {
    ProblemDto createProblem(ProblemDto problemDto);
    ProblemDto getProblemById(Long id);
    List<ProblemDto> getAllProblems();
    ProblemDto updateProblem(Long id, ProblemDto updatedProblem);
    void deleteProblem(Long id);

}
