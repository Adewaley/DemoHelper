package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Manufacture;
import com.example.demo.Service.ServiceImpl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService ;

    private User user;

//    @BeforeEach
//    public void setup() {
//        User user1 = new User();
//        user1.setName("userTestName");
//        user1.setEmail("userTestEmail");
//        user1.setPassword("userTestPassword");
//
//        user = userService.saveUser(user1);
//        System.out.println("User: " + user);
//    }

    @Test
    public void saveTest() {
        User user2 = new User();
        System.out.println(user2);
        user2.setName("userTestName");
        user2.setPassword("userTestPassword");
        user2.setEmail("userTestEmail");

        boolean savedUser = userService.saveUser(user2);
        Assertions.assertTrue(savedUser);
    }

    @Test
    public void findOneByIdTest() {
        User gotUser = userService.findOneUserById(user.getId());
        Assertions.assertEquals(user.getId(), gotUser.getId());
    }
}
