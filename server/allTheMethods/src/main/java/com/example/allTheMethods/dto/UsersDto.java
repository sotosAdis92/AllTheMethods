package com.example.allTheMethods.dto;

import com.example.allTheMethods.enus.UserRole;
import lombok.Data;

@Data
public class UsersDto {
    private Long userId;
    private String username;
    private String password;
    private String displayName;
    private UserRole userRole;

    public UsersDto() {
    }

    public UsersDto(Long userId, String username, String password, String displayName, UserRole userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.userRole = userRole;
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

    public UserRole getUserRole() {
        return userRole;
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

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
