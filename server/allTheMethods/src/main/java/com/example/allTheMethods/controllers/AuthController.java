package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.AuthenticationRequest;
import com.example.allTheMethods.dto.response.AuthenticationResponse;
import com.example.allTheMethods.dto.SignupRequest;
import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.AuthService;
import com.example.allTheMethods.service.UsersService;
import com.example.allTheMethods.utils.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    private final UsersService usersService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;


    public AuthController(AuthService authService, UsersService usersService, JWTUtil jwtUtil, AuthenticationManager authenticationManager, UsersRepository usersRepository) {
        this.authService = authService;
        this.usersService = usersService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
    }

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
            String jwt = jwtUtil.generateToken(userDetails, createdUser.getId());
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setJwtToken(jwt);
            authenticationResponse.setName(createdUser.getDisplayName());
            return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "An unexpected error occurred" + e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

            UserDetails userDetails = usersService.userDetailsService().loadUserByUsername(authenticationRequest.getUsername());
            Optional<Users> optionalUsers = usersRepository.findFirstByUsername(userDetails.getUsername());

            if(optionalUsers.isPresent()){
                Users users = optionalUsers.get();
                String jwt = jwtUtil.generateToken(userDetails, users.getId());
                AuthenticationResponse authenticationResponse = new AuthenticationResponse();
                authenticationResponse.setJwtToken(jwt);
                authenticationResponse.setName(users.getDisplayName());

                return ResponseEntity.ok(authenticationResponse);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "User not found"));
        } catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "Incorrect username or password"));
        } catch (DisabledException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Collections.singletonMap("message", "User account is disabled"));
        } catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "User not found"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "An unexpected error occurred" + e.getMessage()));
        }
    }
}
