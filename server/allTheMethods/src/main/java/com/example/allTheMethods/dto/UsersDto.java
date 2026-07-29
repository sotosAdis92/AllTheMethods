package com.example.allTheMethods.dto;


import com.example.allTheMethods.enus.UserRole;

public record UsersRequestDto(
        Long id,
        String username,
        String password,
        String displayName,
        UserRole userRole
){

}