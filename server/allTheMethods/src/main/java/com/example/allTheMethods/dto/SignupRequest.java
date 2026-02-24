package com.example.allTheMethods.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String displayName;
}
