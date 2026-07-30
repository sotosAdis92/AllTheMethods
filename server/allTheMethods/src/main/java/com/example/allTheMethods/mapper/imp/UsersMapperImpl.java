package com.example.allTheMethods.mapper.imp;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.dto.request.CreateUserAccountRequest;
import com.example.allTheMethods.dto.response.CreateUserAccountResponse;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.enus.UserRole;
import com.example.allTheMethods.exception.NullUserException;
import com.example.allTheMethods.mapper.UsersMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users toEntity(CreateUserAccountRequest request) throws NullPointerException{
        if(request == null){
            System.out.println("Null Request sent by the user, abort all operations");
            throw new NullPointerException("Null Request sent by the user, abort all operations");
        }
        Users user = new Users();
        user.setUsername(request.getUsername().toLowerCase());
        user.setDisplayName(request.getDisplayName());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        return user;
    }

    @Override
    public CreateUserAccountResponse toDto(Users user) throws NullUserException {
        if(user == null){
            System.out.println("no user returned");
            throw new NullUserException("no user returned");
        }
        return new CreateUserAccountResponse(
                user.getId(),
                user.getUsername(),
                user.getDisplayName(),
                user.getUserRole()
        );
    }
}
