package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public User findByLogin(String login) {
        Optional<User> userByLogin = userRepository.findUserByLogin(login);
        if(userByLogin.isEmpty()){
            return null;
        }
        User user = userByLogin.get();
        return user;
    }

}
