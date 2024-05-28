package com.example.CRUD.services;

import com.example.CRUD.entities.Users;
import com.example.CRUD.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users user){
        return usersRepository.save(user);
    }

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    public Optional<Users> getUser(Long id){
        return usersRepository.findById(id);
    }

    public Optional<Users> updateUser(Long id, Users updatedUser) {
        return usersRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return usersRepository.save(user);
        });
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }
}
