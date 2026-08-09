package com.example.allTheMethods.repository;
import com.example.allTheMethods.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByUsername(String username);
    Page<Optional<Users>> findAll(Pageable pageable);
}
