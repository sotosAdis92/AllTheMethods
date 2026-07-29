package com.example.allTheMethods.dto;

import com.example.allTheMethods.enus.UserRole;
import lombok.Data;

@Data
public class UsersDto {
    private Long id;
    private String username;
    private String password;
    private String displayName;
    private UserRole userRole;

    public UsersDto() {
    }

    public UsersDto(Long id, String username, String password, String displayName, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.userRole = userRole;
    }

    public UsersDto(Long id, String username, String displayName) {
        this.id = id;
        this.username = username;
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
