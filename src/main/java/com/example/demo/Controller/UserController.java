package com.example.demo.Controller;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Service.ServiceImpl.MyUserDetailService;
import com.example.demo.Service.ServiceImpl.UserServiceImpl;
import com.example.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController// @CONTROLLER + @response body
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private AuthenticationManager myauthenticaitonManager;
    @Autowired
    private UserService userService; // new userService()

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailService userDetailService;

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
        user.setRole(Role.ADMIN);
        return true;
    }

    @GetMapping("/users/id")
    public User findById(@RequestParam("id") Integer id) {
        return userService.findOneUserById(id);
    }

//    @PutMapping("/users/upd")
//    public boolean updateUser(@RequestParam("id") Integer id,
//                           @RequestParam("name") String name,
//                           @RequestParam("email") String email,
//                           @RequestParam("password") String password) {
//        User user= userService.findOneUserById(id);
//        user.setName(name);
//        user.setPassword(password);
//        user.setEmail(email);
//        return userService.saveUser(user);
//    }

    //sign in
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="username") String username,
                                                       @RequestParam(name="password") String password)
    //@RequestBody User User)
            throws Exception {

        try {
            myauthenticaitonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)//User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailService
                .loadUserByUsername(username);//User.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getName()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.ADMIN);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping
    public void delete(int id, String password) {
        userService.delete(id, userService.findOneUserById(id).getPassword());
    }

    @GetMapping("/login") public String login()
    {
        return "login.html";
    }

    @GetMapping("/admin") public String user()
    {
        return "Admin.html";
    }

    @GetMapping("/welcome") public String welcome()
    {
        return "welcome.html";
    }
}
