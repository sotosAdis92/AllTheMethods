package com.example.allTheMethods.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AuthenticationResponse {
    private String jwtToken;
    private String name;
}
