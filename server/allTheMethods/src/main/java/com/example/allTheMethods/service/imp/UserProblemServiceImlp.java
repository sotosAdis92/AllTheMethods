package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.UserProblemsRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UserProblemService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserProblemServiceImlp implements UserProblemService {
    private final JWTUtil jwtUtil;
    private final UserProblemsRepository userProblemsRepository;
    private final UsersRepository usersRepository;
    private final ProblemRepository problemRepository;

    public UserProblemServiceImlp(JWTUtil jwtUtil, UserProblemsRepository userProblemsRepository, UsersRepository usersRepository, ProblemRepository problemRepository) {
        this.jwtUtil = jwtUtil;
        this.userProblemsRepository = userProblemsRepository;
        this.usersRepository = usersRepository;
        this.problemRepository = problemRepository;
    }

    @Override
    public List<UserProblemDto> getUserProblems() {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            List<Object[]> result = userProblemsRepository.findAllByUserId(user.getId());
            return result.stream().map(row ->{
                UserProblemDto userProblemDto = new UserProblemDto();
                userProblemDto.setId((Long) row[0]);
                userProblemDto.setNumber((Integer) row[1]);
                userProblemDto.setTitle((String) row[2]);
                userProblemDto.setCategory((String) row[3]);
                userProblemDto.setDifficulty((String) row[4]);
                userProblemDto.setDescription((String) row[5]);
                userProblemDto.setPoints((Integer) row[6]);
                userProblemDto.setUserId((Long) row[7]);
                return userProblemDto;
            }).collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found");
    }
}
