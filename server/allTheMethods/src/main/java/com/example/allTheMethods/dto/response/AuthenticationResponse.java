package com.example.allTheMethods.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwtToken;
    private String name;

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getName() {
        return name;
    }
}
