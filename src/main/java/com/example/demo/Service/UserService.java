package com.example.demo.Service;

import com.example.demo.Entity.User;

import org.springframework.stereotype.Component;

public interface UserService {
    public User saveUser(User user);

    public User findByUserId(int id);
}
