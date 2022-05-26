package com.example.demo.Service.ServiceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.transaction.annotation.Transactional;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByName(username).orElse(null);
    }

    @Override
    public User findOneUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

//    @Override
//    public boolean saveUser(User user) {
//
//        //User user = new User();
//        try{
//            userRepository.save(user);
//        }catch(Exception e){
//            System.out.println("" + e.getMessage());
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public void createOneUser() {
        User user1 = new User();
        user1.setName("Ade Wale");
        user1.setEmail("adewaley@itlize.com");
        user1.setPassword("MOM");
        user1.setTimeOfCreation(new Timestamp(System.currentTimeMillis()));
        user1.setLastLogin(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user1);
    }

    @Override
    public void delete(int id, String password) {
        User toBeDeleted = findOneUserById(id);
        if(toBeDeleted == null) System.out.println("Does not exist");
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("" + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

}
