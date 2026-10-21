package com.example.allTheMethods.service.imp;

import com.example.allTheMethods.dto.request.UpdateUserRequestDto;
import com.example.allTheMethods.dto.response.UserResponseDto;
import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.exception.UserNotFoundException;
import com.example.allTheMethods.exception.UsernameNotFoundException;
import com.example.allTheMethods.mapper.UsersMapper;
import com.example.allTheMethods.repository.UsersRepository;
import com.example.allTheMethods.service.UsersService;
import com.example.allTheMethods.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final JWTUtil jwtUtil;
    private final UsersMapper usersMapper;
    private final FileService fileService;

    public UsersServiceImpl(UsersRepository usersRepository, JWTUtil jwtUtil, UsersMapper usersMapper, FileService fileService) {
        this.usersRepository = usersRepository;
        this.jwtUtil = jwtUtil;
        this.usersMapper = usersMapper;
        this.fileService = fileService;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return usersRepository.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with this username"));
            }
        };
    }

    @Override
    public UserResponseDto getUserName(){
       Users currentUser = jwtUtil.getLoggedInUser();
       return usersMapper.toDto(currentUser);
    }

    @Override
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        Page<UserResponseDto> users = usersMapper.toDto(usersRepository.findAll(pageable));
        return users;
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteById((long) id);
    }

    @Override
    public UserResponseDto updateUserAccount(int id, UpdateUserRequestDto updateUserRequestDto) {
        Users user = usersRepository.findById((long) id).orElseThrow(() -> new UsernameNotFoundException("User not found with this id"));
        user.setUsername(updateUserRequestDto.username());
        user.setDisplayName(updateUserRequestDto.displayName());
        return usersMapper.toDto(user);
    }

    @Override
    public UserResponseDto uploadImage(Long id, MultipartFile file) throws IOException {
        Users user = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user found with id of: " + id));
        String imageUrl = fileService.uploadImage(id,file);
        user.setImageUrl(imageUrl);
        Users savedUser = usersRepository.save(user);
        return usersMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto deleteImage(Long id) throws IOException {
        Users user = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user found with id of: " + id));
        fileService.deleteImage(id);
        user.setImageUrl(null);
        Users savedUser = usersRepository.save(user);
        return usersMapper.toDto(savedUser);
    }


}
