package com.server.software.dev.kolesnyk.controller;

import com.server.software.dev.kolesnyk.entity.User;
import com.server.software.dev.kolesnyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/home/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userRepository.getById(userId);
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return userRepository.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.create(user);
    }

    @PutMapping("/{userId}")
    public void updateUser(@RequestBody User user, @PathVariable int userId) {
        userRepository.update(user, userId);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.delete(userId);
    }
}
