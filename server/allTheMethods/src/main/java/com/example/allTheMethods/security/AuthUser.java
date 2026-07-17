package com.example.allTheMethods.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AuthUser extends User {
    private final Long id;
    private final String displayName;
    public AuthUser(Long id, String username, String password, String displayName, Collection<? extends GrantedAuthority> authorities){
        super(username, password,authorities);
        this.id = id;
        this.displayName = displayName;
    }
    public Long getId(){
        return id;
    }

    public String getDisplayName(){
        return displayName;
    }
}
