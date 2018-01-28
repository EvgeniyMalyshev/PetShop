package com.petshop.petshop.service;


import com.petshop.petshop.model.User;
import com.petshop.petshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user){
        userRepository.save(user);
    }
    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }
    public List<User> getListUser(){
        return userRepository.findAll();
    }
}
