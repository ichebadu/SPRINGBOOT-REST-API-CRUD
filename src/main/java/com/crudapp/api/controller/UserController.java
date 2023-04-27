package com.crudapp.api.controller;

import com.crudapp.api.dto.UserDto;
import com.crudapp.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> userDtos = userService.getAllUser();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updatePost(@RequestBody UserDto userDto, @PathVariable(name = "id") Long userId) {
        UserDto userDtos1 = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(userDtos1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>("post deleted successfully", HttpStatus.OK);
    }
}