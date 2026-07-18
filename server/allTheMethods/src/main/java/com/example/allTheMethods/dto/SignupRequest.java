package com.example.allTheMethods.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SignupRequest {
    private String username;
    private String password;
    private String displayName;
}
