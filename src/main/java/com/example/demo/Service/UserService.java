package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findAllUser();

    User findByUsername(String username);

    User findOneUserById(Integer id);

    User saveUser(User category);

    public void createOneUser();

    public boolean delete(int id, String password);

    public List<User> findByRole(Role role);
}
