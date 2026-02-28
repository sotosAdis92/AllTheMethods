package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public UsersDto getUserName(){
        return usersService.getUserName();
    }
}
