package com.example.CRUD.controller;

import com.example.CRUD.entities.Users;
import com.example.CRUD.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/findAll")
    public List<Users> findAll(){
        return usersService.getUsers();
    }

    @GetMapping("/find/{id}")
    public Optional<Users> findById(@PathVariable Long id){
        return usersService.getUser(id);
    }

    @PostMapping("/create")
    public Users createUsers(@RequestBody Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersService.createUser(users);
    }

    @PutMapping("/update/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Optional<Users> optionalUser = usersService.updateUser(id, updatedUser);
        return updatedUser;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        usersService.deleteUser(id);
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersService.createUser(users);
    }
}
