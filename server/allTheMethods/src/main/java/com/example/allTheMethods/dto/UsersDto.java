package com.example.allTheMethods.dto;

import com.example.allTheMethods.enus.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
