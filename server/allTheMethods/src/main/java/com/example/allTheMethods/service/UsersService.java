package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.UpdateUserRequest;
import com.example.allTheMethods.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface UsersService {
    UserDetailsService userDetailsService();
    UserResponseDto getUserName();
    Page<UserResponseDto> getAllUsers(Pageable pageable);
    void deleteUser(int id);
    UserResponseDto updateUserAccount(int id, UpdateUserRequest updateUserRequest);
    UserResponseDto uploadImage(Long id, MultipartFile file) throws IOException;
    UserResponseDto deleteImage(Long id) throws IOException;
}
