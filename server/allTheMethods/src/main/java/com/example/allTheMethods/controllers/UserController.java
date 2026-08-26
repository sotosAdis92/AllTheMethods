package com.example.allTheMethods.controllers;

import com.example.allTheMethods.dto.request.UpdateUserRequestDto;
import com.example.allTheMethods.dto.response.SubmissionResponse;
import com.example.allTheMethods.dto.response.UserResponseDto;

import com.example.allTheMethods.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/username")
    public UserResponseDto getUserName(){
        return usersService.getUserName();
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<UserResponseDto>> getAllUsers(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "30") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "DESC") String sortDir
    ){
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Page<UserResponseDto> users = usersService.getAllUsers(PageRequest.of(pageNo-1,pageSize, sort));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        usersService.deleteUser(id);
        return ResponseEntity.ok("Deleted user");
    }

    @PutMapping("/details/{id}")
    public ResponseEntity<String> updateUserAccount(@PathVariable int id,@RequestBody UpdateUserRequestDto updateUserRequestDto){
        usersService.updateUserAccount(id,updateUserRequestDto);
        return ResponseEntity.ok("User updated");
    }

}
