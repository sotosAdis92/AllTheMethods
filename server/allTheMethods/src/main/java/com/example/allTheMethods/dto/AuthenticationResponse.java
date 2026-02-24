package com.example.allTheMethods.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwtToken;
    private String name;
}
