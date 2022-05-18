package com.example.demo.Controller;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping("/users/create")
    public boolean create(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password,
                       @RequestParam("admin") String admin) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(admin);
        return true;
    }

    @GetMapping("/users/id")
    public User findById(@RequestParam("id") Integer id) {
        return userService.findOneUserById(id);
    }

    @PutMapping("/users/upd")
    public boolean updateUser(@RequestParam("id") Integer id,
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

    @PostMapping
    public void delete(int id, String password) {
        userService.delete(id, userService.findOneUserById(id).getPassword());
    }
}
