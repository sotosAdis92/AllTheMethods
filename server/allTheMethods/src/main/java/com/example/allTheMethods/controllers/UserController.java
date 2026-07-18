package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.enus.UserRole;
import com.example.allTheMethods.security.AuthUser;
import com.example.allTheMethods.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDetailsService userDetailsService;

    @GetMapping("/username")
    public UsersDto getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        UsersDto usersDto = new UsersDto();
        usersDto.setId(authUser.getId());
        usersDto.setUsername(authUser.getUsername());
        usersDto.setDisplayName(authUser.getDisplayName());
        return usersDto;
    }
}
