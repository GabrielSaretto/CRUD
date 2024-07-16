package com.example.CRUD.controller;

import com.example.CRUD.entities.Users;
import com.example.CRUD.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Users> findAll() {
        return usersService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<Users> findById(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersService.createUser(users);
    }
    
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        return usersService.updateUser(id, updatedUser)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersService.createUser(users);
    }
}
