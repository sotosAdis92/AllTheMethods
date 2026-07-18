package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.UsersDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.security.AuthUser;
import com.example.allTheMethods.service.UsersService;
import com.example.allTheMethods.utils.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@Service
public class UsersServiceImpl implements UserDetailsService {
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final JWTUtil jwtUtil;

    private Collection<? extends GrantedAuthority> getAuthorities(Users user){
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users user = usersRepository.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new AuthUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getDisplayName(),
                getAuthorities(user)
        );
    }
}
