package com.example.allTheMethods.entity;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.enus.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String displayName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    Set<UserAchievements> achievements;

    @OneToMany(mappedBy = "user")
    Set<Submission> submissions;

    public Users(Long id, String username, String password, String displayName, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.userRole = userRole;
    }

    public UsersDto getUsersDto(){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(id);
        usersDto.setDisplayName(displayName);
        usersDto.setUsername(username);
        usersDto.setUserRole(userRole);
        return usersDto;
    }
}
