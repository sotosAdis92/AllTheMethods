package com.example.allTheMethods.mapper;

import com.example.allTheMethods.entity.Problem;
import org.springframework.stereotype.Component;

@Component
public interface ProblemMapper {
    Problem toEntity();

}
