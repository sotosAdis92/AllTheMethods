package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.AuthenticationRequest;
import com.example.allTheMethods.dto.AuthenticationResponse;
import com.example.allTheMethods.dto.SignupRequest;
import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.service.AuthService;
import com.example.allTheMethods.service.UsersService;
import com.example.allTheMethods.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsersService usersService;
    private final JWTUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        try{
            if(authService.hasUserWithUsername(signupRequest.getUsername())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("message", "Username already exists"));
            }
            UsersDto createdUser = authService.createUser(signupRequest);
            if(createdUser == null){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("message", "User creation failed, please try again"));
            }
            UserDetails userDetails = usersService.userDetailsService().loadUserByUsername(createdUser.getUsername());
            String jwt = jwtUtil.generateToken(userDetails, createdUser.getUserId());
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setJwtToken(jwt);
            authenticationResponse.setName(createdUser.getDisplayName());
            return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "An unexpected error occurred" + e.getMessage()));
        }
    }
}
