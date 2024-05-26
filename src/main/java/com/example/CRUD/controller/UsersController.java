package com.example.CRUD.controller;

import com.example.CRUD.entities.Users;
import com.example.CRUD.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    @RequestMapping("/create")
    public Users createUsers(@RequestBody Users users){
        return usersService.createUser(users);
    }

}
