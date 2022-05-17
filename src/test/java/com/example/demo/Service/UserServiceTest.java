package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Manufacture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest {
    @Autowired
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup() {
        User user1 = new User();
        user1.setName("userTestName");
        user1.setEmail("userTestEmail");
        user1.setPassword("userTestPassword");

        user = userService.saveUser(user1);
    }

    @Test
    public void saveTest() {
        User user2 = new User();
        user2.setName("userTestName");
        user2.setPassword("userTestPassword");
        user2.setEmail("userTestEmail");
        User savedUser = userService.saveUser(user2);
        Assertions.assertEquals(savedUser.getEmail(), user2.getName());
    }

    @Test
    public void findOneByIdTest() {
        User gotUser = userService.findOneUserById(user.getId());
        Assertions.assertEquals(user.getId(), gotUser.getId());
    }
}
