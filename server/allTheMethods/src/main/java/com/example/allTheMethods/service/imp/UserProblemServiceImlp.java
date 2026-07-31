package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.dto.request.SaveUserProblemRequestDto;
import com.example.allTheMethods.dto.response.UserProblemResponse;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.UserProblemMapper;
import com.example.allTheMethods.mapper.imp.UserProblemMapperImpl;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.UserProblemsRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UserProblemService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserProblemServiceImlp implements UserProblemService {
    private final JWTUtil jwtUtil;
    private final UserProblemsRepository userProblemsRepository;
    private final UsersRepository usersRepository;
    private final ProblemRepository problemRepository;
    private final UserProblemMapper userProblemMapper;

    public UserProblemServiceImlp(JWTUtil jwtUtil, UserProblemMapper userProblemMapper, UserProblemsRepository userProblemsRepository, UsersRepository usersRepository, ProblemRepository problemRepository) {
        this.jwtUtil = jwtUtil;
        this.userProblemMapper = userProblemMapper;
        this.userProblemsRepository = userProblemsRepository;
        this.usersRepository = usersRepository;
        this.problemRepository = problemRepository;
    }

    @Override
    public UserProblemResponse saveUserProblem(SaveUserProblemRequestDto userProblemRequest) {
        Users user = usersRepository.findById(userProblemRequest.userId()).orElseThrow();
        Problem problem = problemRepository.findById(userProblemRequest.problemId()).orElseThrow();
        UserProblem userProblem = userProblemMapper.toEntity(userProblemRequest);
        userProblem.setUser(user);
        userProblem.setProblem(problem);
        UserProblem savedUserProblem = userProblemsRepository.save(userProblem);
        return userProblemMapper.toDto(savedUserProblem);
    }

    @Override
    public List<UserProblemResponse> getUserProblemsByUserId(int id) {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            List<UserProblem> userProblems = userProblemsRepository.findAllByUserId((long) id);
            return userProblemMapper.toDto(userProblems);
        }
        throw new EntityNotFoundException("User not found");
    }

    @Override
    public boolean checkIfUserSolvedAProblem(int id) {
        Users user = jwtUtil.getLoggedInUser();
        boolean flag = false;
        if(user!=null){
            List<UserProblem> usersSolvedProblems = userProblemsRepository.findAllByUserId((long) id);
            for(int i=0;i<usersSolvedProblems.size();i++){
                if(usersSolvedProblems.get(i).getProblem().getId().equals((long) id)){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public List<Object> countAllByUserAndProblemDifficulty(int id){
        Users user = jwtUtil.getLoggedInUser();
        List<Object> countProblemsByDifficulty = new ArrayList<>();
        if(user!=null){
            countProblemsByDifficulty = userProblemsRepository.countAllByUserAndProblemDifficulty((long) id);
        }
        return countProblemsByDifficulty;
    }

    @Override
    public List<Object> countDistinctSolvedProblemsByDifficultyForUser(int id){
        Users user = jwtUtil.getLoggedInUser();
        List<Object> countDistinctSolved = new ArrayList<>();
        if(user!=null){
            countDistinctSolved = userProblemsRepository.countDistinctSolvedByDifficultyFromUser((long) id);
        }
        return countDistinctSolved;
    }

    @Override
    public List<Object> countDistinctSolvedProblemsByCategoryForUser(int id) {
        Users user = jwtUtil.getLoggedInUser();
        List<Object> countDistinctSolved = new ArrayList<>();
        if(user!=null){
            countDistinctSolved = userProblemsRepository.countDistinctByIdAndCategory((long) id);
        }
        return countDistinctSolved;
    }


}
