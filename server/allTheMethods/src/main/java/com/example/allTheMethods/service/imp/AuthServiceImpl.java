package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.dto.response.CreateUserAccountResponse;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.enus.UserRole;
import com.example.allTheMethods.exception.UsernameAlreadyExistsException;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;

    public AuthServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional
    public CreateUserAccountResponse createUser(CreateUserAccountRequest createUserAccountRequest) {
        if(hasUserWithUsername(createUserAccountRequest.getUsername())){
            throw new UsernameAlreadyExistsException("Username already exists: " + createUserAccountRequest.getUsername());
        }
        Users user = new Users();
        user.setUsername(createUserAccountRequest.getUsername().toLowerCase());
        user.setDisplayName(createUserAccountRequest.getDisplayName());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(createUserAccountRequest.getPassword()));
        Users createduser = usersRepository.save(user);
        return new CreateUserAccountResponse(
                createduser.getId(),
                createduser.getUsername(),
                createduser.getDisplayName(),
                createduser.getUserRole()
        );
    }

    @Override
    public Boolean hasUserWithUsername(String username) {
        return usersRepository.findFirstByUsername(username).isPresent();
    }
}
