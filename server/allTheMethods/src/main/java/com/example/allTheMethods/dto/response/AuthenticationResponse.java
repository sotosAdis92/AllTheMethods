package com.example.allTheMethods.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwtToken;
    private String name;
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
