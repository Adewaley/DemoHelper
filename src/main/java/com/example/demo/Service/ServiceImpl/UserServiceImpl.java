package com.example.demo.Service.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Project;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findOneUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public void createOneUser() {
        User user1 = new User();
        user1.setName("Ade Wale");
        user1.setEmail("adewaley@itlize.com");
        user1.setPassword("MOM");
    }

    @Override
    public List<User> findByAdmin(String admin) {
        return userRepository.findByAdmin(admin);
    }

}
