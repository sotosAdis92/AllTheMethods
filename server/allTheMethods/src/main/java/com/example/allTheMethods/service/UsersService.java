package com.example.allTheMethods.service;

import com.example.allTheMethods.dto.request.UpdateUserRequest;
import com.example.allTheMethods.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface UsersService {
    UserDetailsService userDetailsService();
    UserResponse getUserName();
    Page<UserResponse> getAllUsers(Pageable pageable);
    void deleteUser(int id);
    UserResponse updateUserAccount(int id, UpdateUserRequest updateUserRequest);
    UserResponse uploadImage(Long id, MultipartFile file) throws IOException;
    UserResponse deleteImage(Long id) throws IOException;
}
