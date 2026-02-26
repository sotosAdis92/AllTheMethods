package com.example.allTheMethods.entity;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.enus.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String displayName;

    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    Set<UserAchievements> achievements;

    public Users() {
    }

    public Users(Long userId, String username, String password, String displayName, UserRole userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.userRole = userRole;
    }

    public Users(Long userId, String username, String password, String displayName, UserRole userRole, Set<UserAchievements> achievements) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.userRole = userRole;
        this.achievements = achievements;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
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

    public Set<UserAchievements> getAchievements() {
        return achievements;
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

    public void setAchievements(Set<UserAchievements> achievements) {
        this.achievements = achievements;
    }

    public UsersDto getUsersDto(){
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId(userId);
        usersDto.setDisplayName(displayName);
        usersDto.setUsername(username);
        usersDto.setUserRole(userRole);
        return usersDto;
    }
}
