package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;

    @Override
    public Boolean hasUserWithUsername(String username) {
        return usersRepository.findFirstByUsername(username).isPresent();
    }
}
