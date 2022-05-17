package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping("/users")
    public User create(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password,
                       @RequestParam("admin") String admin) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(admin);
        return userService.saveUser(user);
    }

    @GetMapping("/users/")
    public User findById(@RequestParam("id") Integer id) {
        return userService.findOneUserById(id);
    }

    @PutMapping("/users/")
    public User updateUser(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        User user= userService.findOneUserById(id);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        return userService.saveUser(user);
    }

    @PostMapping("/users/one")
    public void createUser() {
        userService.createOneUser();
    }


}
