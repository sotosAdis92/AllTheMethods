package com.example.allTheMethods.jwt;

import java.util.List;

public class LoginResponse {
    private String jwtToken;
    private String username;
    private List<String> roles;

    public LoginResponse() {
    }

    public LoginResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    public LoginResponse(String username, List<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public LoginResponse(String jwtToken, String username, List<String> roles) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
