package com.example.CRUD.services;

import com.example.CRUD.entities.Users;
import com.example.CRUD.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users user){
        return usersRepository.save(user);
    }

}
