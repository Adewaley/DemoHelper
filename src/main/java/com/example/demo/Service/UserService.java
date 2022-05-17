package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.User;

import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    User findOneUserById(Integer id);

    User saveUser(User category);

    public void createOneUser();

    public void delete(int id, String password);

    public List<User> findByAdmin(String admin);
}
