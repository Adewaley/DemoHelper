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
@CrossOrigin(origins="http://localhost:4200")
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

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAllUser();
    }

    @PostMapping("/create")
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
    public ResponseEntity<?> createAuthenticationToken(@RequestParam (name="username") String username,
                                                       @RequestParam (name="password") String password)
                                                        //@RequestBody User User)
            throws Exception {

//        String username = user.getName();
//        String password = user.getPassword();

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

       // add code for conflict if user already exists
        if (userService.findByUsername(user.getName()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

//    @PostMapping("/createUser")
//    public ResponseEntity<?> register(@RequestParam("name") String name,
//                          @RequestParam("email") String email,
//                          @RequestParam("password") String password,
//                          @RequestParam("admin") String admin) {
//        User user = new User();
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setRole(Role.ADMIN);
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }

    @PostMapping("/deleteUser")
    public ResponseEntity<?> delete(@RequestParam("password") String password, @RequestParam("id") int id) {

        return new ResponseEntity<>(userService.delete(id, password), HttpStatus.OK);
    }

}
