package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.SignupRequest;
import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.enus.UserRole;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;

    @Override
    public UsersDto createUser(SignupRequest signupRequest) {
        Users user = new Users();
        user.setUsername(signupRequest.getUsername());
        user.setDisplayName(signupRequest.getDisplayName());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        Users createduser = usersRepository.save(user);
        return createduser.getUsersDto();
    }

    @Override
    public Boolean hasUserWithUsername(String username) {
        return usersRepository.findFirstByUsername(username).isPresent();
    }
}
