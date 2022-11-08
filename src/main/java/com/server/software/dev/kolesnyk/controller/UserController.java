package com.server.software.dev.kolesnyk.controller;

import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.UserEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.of(userService.getUser(userId));
    }

    @GetMapping
    public Collection<UserEntity> getAllUsers(@RequestParam Integer page, @RequestParam Integer size) {
        return userService.getAllUsers(page, size);
    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserDto user) {
        userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public void updateUser(@RequestBody @Valid UserDto user, @PathVariable Integer userId) {
        userService.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}
