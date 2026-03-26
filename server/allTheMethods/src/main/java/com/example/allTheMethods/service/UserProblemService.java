package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.UserProblemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProblemService {
    List<UserProblemDto> getUserProblems();
}
