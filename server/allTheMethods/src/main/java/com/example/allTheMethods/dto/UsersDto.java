package com.example.allTheMethods.dto;

import lombok.Data;

@Data
public class UsersDto {
    private Long userId;
    private String username;
    private String password;
    private String displayName;

    public UsersDto() {
    }

    public UsersDto(Long userId, String username, String password, String displayName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
