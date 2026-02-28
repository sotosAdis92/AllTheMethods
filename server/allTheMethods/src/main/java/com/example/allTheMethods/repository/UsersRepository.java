package com.example.allTheMethods.repository;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByUsername(String username);
}
