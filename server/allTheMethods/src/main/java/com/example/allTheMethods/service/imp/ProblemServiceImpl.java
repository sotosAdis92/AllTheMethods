package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.CreateProblemRequestDto;
import com.example.allTheMethods.dto.request.UpdateProblemRequestDto;
import com.example.allTheMethods.dto.response.ProblemResponseDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.exception.ResourceNotFoundException;
import com.example.allTheMethods.mapper.ProblemMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.service.ProblemService;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;


import static com.example.allTheMethods.utils.MethodUtils.cleanList;

@Service
public class ProblemServiceImpl implements ProblemService {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;

    public ProblemServiceImpl(ProblemRepository problemRepository, ProblemMapper problemMapper) {
        this.problemRepository = problemRepository;
        this.problemMapper = problemMapper;
    }

    @Override
    public ProblemResponseDto createProblem(CreateProblemRequestDto problemDto) {
        Problem problem = problemMapper.toEntity(problemDto);
        return problemMapper.toDto(problemRepository.save(problem));
    }

    @Override
    public ProblemResponseDto getProblemById(int id) {
        Problem problem = problemRepository.findById((long) id).orElseThrow(() -> new ResourceNotFoundException("Problem not found" + id));
        return problemMapper.toDto(problem);
    }

    @Override
    public List<ProblemResponseDto> getAllProblems() {
        List<Problem> allProblems = problemRepository.findAll();
        return problemMapper.toDto(allProblems);
    }

    @Override
    public ProblemResponseDto updateProblem(Long id, UpdateProblemRequestDto updatedProblem) {
        Problem problem = problemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Problem not found" + id));
        problem.setNumber(updatedProblem.number());
        problem.setCategory(updatedProblem.category());
        problem.setDifficulty(updatedProblem.difficulty());
        problem.setTitle(updatedProblem.title());
        problem.setDescription(updatedProblem.description());
        problem.setPoints(updatedProblem.points());
        problem.setProblemString(updatedProblem.problemString());
        problem.setFunctionString(updatedProblem.functionString());
        problem.setProblemData(updatedProblem.problemData());
        problem.setProblemData(updatedProblem.problemType());
        Problem updatedProblemObj = problemRepository.save(problem);
        return problemMapper.toDto(updatedProblemObj);
    }

    @Override
    public void deleteProblem(Long id) {
        Problem problem = problemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Problem not found" + id));
        problemRepository.deleteById(id);
    }

    @Override
    public List<ProblemResponseDto> getProblemsByCategory(String category){
        List<Problem> problemsByCategory = problemRepository.findProblemByCategory(category);
        return problemMapper.toDto(problemsByCategory);
    }

    @Override
    public List<ProblemResponseDto> getProblemsByDifficulty(String difficulty){
        List<Problem> problemsByDifficulty = problemRepository.findProblemByDifficulty(difficulty);
        return problemMapper.toDto(problemsByDifficulty);
    }

    @Override
    public List<ProblemResponseDto> getProblemsByCategoryOrDifficulty(List<String> categories, List<String> difficulties){
        categories = cleanList(categories);
        difficulties = cleanList(difficulties);
        List<Problem> problemsByCategoryAndDifficulty;

        if (categories != null && difficulties != null) {
            problemsByCategoryAndDifficulty = problemRepository.findProblemsByCategoryOrDifficulty(categories,difficulties);
        }
        else if(difficulties != null){
            problemsByCategoryAndDifficulty = problemRepository.findProblemsByDifficultyIn(difficulties);
        }
        else if(categories != null){
            problemsByCategoryAndDifficulty = problemRepository.findProblemsByCategoryIn(categories);
        }
        else{
            problemsByCategoryAndDifficulty = problemRepository.findAll();
        }
        return problemMapper.toDto(problemsByCategoryAndDifficulty);
    }

    public long countAllTheExistingProblems(){
        return problemRepository.count();
    }

    public List<ProblemResponseDto> getAllProblemsPaged(Pageable pageable){
        return problemMapper.toDto(problemRepository.findAll(pageable).getContent());
    }
}
