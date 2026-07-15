package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.exception.ResourceNotFoundException;
import com.example.allTheMethods.mapper.ProblemMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.service.ProblemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.allTheMethods.utils.MethodUtils.cleanList;

@Service
public class ProblemServiceImpl implements ProblemService {

    private ProblemRepository problemRepository;

    public ProblemServiceImpl(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public ProblemDto createProblem(ProblemDto problemDto) {
        Problem problem = ProblemMapper.mapToProblem(problemDto);
        Problem savedProblem = problemRepository.save(problem);
        return ProblemMapper.mapToProblemDto(savedProblem);
    }

    @Override
    public ProblemDto getProblemById(Long id) {
        Problem problem = problemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Problem not found" + id));
        return ProblemMapper.mapToProblemDto(problem);
    }

    @Override
    public List<ProblemDto> getAllProblems() {
        List<Problem> problems = problemRepository.findAll();
        return problems.stream().map((problem -> ProblemMapper.mapToProblemDto(problem))).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ProblemDto updateProblem(Long id, ProblemDto updatedProblem) {
        Problem problem = problemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Problem not found" + id));
        problem.setNumber(updatedProblem.getNumber());
        problem.setCategory(updatedProblem.getCategory());
        problem.setDifficulty(updatedProblem.getDifficulty());
        problem.setTitle(updatedProblem.getTitle());
        problem.setDescription(updatedProblem.getDescription());
        problem.setPoints(updatedProblem.getPoints());
        problem.setProblemString(updatedProblem.getProblemString());
        Problem updatedProblemObj = problemRepository.save(problem);
        return ProblemMapper.mapToProblemDto(updatedProblemObj);
    }

    @Override
    public void deleteProblem(Long id) {
        Problem problem = problemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Problem not found" + id));
        problemRepository.deleteById(id);
    }

    @Override
    public List<ProblemDto> getProblemsByCategory(String category){
        List<Problem> problemsByCategory = problemRepository.findProblemByCategory(category);
        return problemsByCategory.stream().map(problem -> ProblemMapper.mapToProblemDto(problem)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<ProblemDto> getProblemsByDifficulty(String difficulty){
        List<Problem> problemsByDifficulty = problemRepository.findProblemByDifficulty(difficulty);
        return problemsByDifficulty.stream().map(problem -> ProblemMapper.mapToProblemDto(problem)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<ProblemDto> getProblemsByCategoryOrDifficulty(List<String> categories, List<String> difficulties){
        categories = cleanList(categories);
        difficulties = cleanList(difficulties);
        List<Problem> problemsByCategoryAndDifficulty;
        if (categories == null && difficulties == null) {
            problemsByCategoryAndDifficulty = problemRepository.findAll();
        }
        else{
            problemsByCategoryAndDifficulty = problemRepository.findProblemsByCategoryOrDifficulty(categories,difficulties);
        }
        return problemsByCategoryAndDifficulty.stream().map(problem -> ProblemMapper.mapToProblemDto(problem)).collect(Collectors.toUnmodifiableList());
    }
}
