package com.nfcsolutionsusa.basicauth.controller;

import com.nfcsolutionsusa.basicauth.model.User;
import com.nfcsolutionsusa.basicauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }

    @GetMapping("/users")
    public List<User> listUsers(){

        return userService.listUsers();
    }
}
