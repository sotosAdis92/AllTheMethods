package com.example.allTheMethods.mapper;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;

public class UsersMapper {
    public static UsersDto mapToUsersDto(Users users){
        return new UsersDto(
                users.getId(),
                users.getUsername(),
                users.getPassword(),
                users.getDisplayName(),
                users.getUserRole()
        );
    }
    public static Users mapToUsers(UsersDto usersDto){
        return new Users(
                usersDto.getId(),
                usersDto.getUsername(),
                usersDto.getPassword(),
                usersDto.getDisplayName(),
                usersDto.getUserRole()
        );
    }
}
