package com.example.allTheMethods.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserProblemsRepositoryTest {
    @Autowired
    private UserProblemsRepository userProblemsRepository;


}
