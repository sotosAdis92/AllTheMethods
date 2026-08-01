package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.response.UserResponseDto;

import com.example.allTheMethods.service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/username")
    public UserResponseDto getUserName(){
        return usersService.getUserName();
    }

}
