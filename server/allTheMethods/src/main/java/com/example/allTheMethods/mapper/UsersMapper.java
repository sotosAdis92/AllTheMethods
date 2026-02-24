package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.ProblemDto;
import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Problem;
import com.example.allTheMethods.entity.Users;

public class UsersMapper {
    public static UsersDto mapToUsersDto(Users users){
        return new UsersDto(
                users.getUserId(),
                users.getUsername(),
                users.getPassword(),
                users.getDisplayName(),
                users.getUserRole()
        );
    }
    public static Users mapToUsers(UsersDto usersDto){
        return new Users(
                usersDto.getUserId(),
                usersDto.getUsername(),
                usersDto.getPassword(),
                usersDto.getDisplayName(),
                usersDto.getUserRole()
        );
    }
}
