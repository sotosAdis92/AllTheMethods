package com.example.allTheMethods.repository;

import com.example.allTheMethods.entity.UserProblem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserProblemsRepositoryTest {
    @Autowired
    private UserProblemsRepository userProblemsRepository;

    @Test
    public void getUserProblemsByUserIdAndGroupByDifficulty(){
       Long userId = 1L;
       List<Object> count = userProblemsRepository.countAllByUserAndProblemDifficulty(userId);
       System.out.println(count);
    }
}
