package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.*;
import com.example.allTheMethods.entity.Submission;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.mapper.SubmissionMapper;
import com.example.allTheMethods.repository.ProblemRepository;
import com.example.allTheMethods.repository.SubmissionRepository;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.SubmissionService;
import com.example.allTheMethods.utils.JWTUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SubmissionServiceImpl implements SubmissionService {
    /* Dependency Injection for SubmissionServiceImpl Class */
    private SubmissionRepository submissionRepository;
    private UsersRepository usersRepository;
    private ProblemRepository problemRepository;
    private SubmissionMapper submissionMapper;
    private final JWTUtil jwtUtil;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository,JWTUtil jwtUtil, UsersRepository usersRepository, ProblemRepository problemRepository, SubmissionMapper submissionMapper) {
        this.submissionRepository = submissionRepository;
        this.jwtUtil = jwtUtil;
        this.usersRepository = usersRepository;
        this.problemRepository = problemRepository;
        this.submissionMapper = submissionMapper;
    }

    @Override
    public SubmissionDto createSubmission(SubmissionDto submissionDto) {
        Submission submission = submissionMapper.mapToSubmission(submissionDto, usersRepository, problemRepository);
        Submission savedSubmission = submissionRepository.save(submission);
        return submissionMapper.mapToSubmissionDto(savedSubmission);
    }

    @Override
    public List<Object> getSubmissionsByUserId(int id) {
        Users user = jwtUtil.getLoggedInUser();
        if(user!=null){
            List<Object> userSubmissions = submissionRepository.findAllByUserId((long) id);
            return userSubmissions;
        }
        throw new EntityNotFoundException("User not found");
    }


}
