package com.example.authserver.service;

import com.example.authserver.model.User;
import com.example.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
