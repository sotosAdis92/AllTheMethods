package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.UserProblemDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.UserProblem;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.UserProblemMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.UserProblemsRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UserProblemService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
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
    public UserProblemDto saveUserProblem(UserProblemDto userProblemDto) {
        System.out.println(userProblemDto.getProblemId());
        Users user = usersRepository.findById(userProblemDto.getUserId()).orElseThrow();
        Problem problem = problemRepository.findById(userProblemDto.getProblemId()).orElseThrow();
        UserProblem userProblem = UserProblemMapper.mapToUserProblem(userProblemDto,user,problem);
        UserProblem savedUserProblem = userProblemsRepository.save(userProblem);
        return UserProblemMapper.mapToUserProblemDto(savedUserProblem);
    }

    @Override
    public List<UserProblemDto> getUserProblems() {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            List<UserProblem> userProblems = userProblemsRepository.findAllByUserId(user.getId());
            return userProblems.stream().map(userProblem -> UserProblemMapper.mapToUserProblemDto(userProblem)).collect(Collectors.toUnmodifiableList());
        }
        throw new EntityNotFoundException("User not found");
    }

    @Override
    public boolean checkIfUserSolvedAProblem(int id) {
        Users user = jwtUtil.getLoggedInUser();
        boolean flag = false;
        System.out.println("=== checkIfUserSolvedAProblem CALLED with id: " + id + " ===");
        if (user != null) {
            List<UserProblem> usersSolvedProblems = userProblemsRepository.findAllByUserId(user.getId());

            // Log user info
            System.out.println("Checking if user ID " + user.getId() + " solved problem " + id);
            System.out.println("Number of solved problems: " + usersSolvedProblems.size());

            // Log each problem ID being checked
            for (int i = 0; i < usersSolvedProblems.size(); i++) {
                Long problemId = usersSolvedProblems.get(i).getProblem().getId();
                System.out.println("Checking problem ID: " + problemId + " against: " + id);

                if (problemId.equals((long) id)) {
                    flag = true;
                    System.out.println("Match found!");
                    break; // Add break for efficiency
                }
            }

            System.out.println("Result: " + flag);
        } else {
            System.out.println("User is null - not logged in");
        }

        return flag;
    }
}
