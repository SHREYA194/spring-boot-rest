package com.project.spring_boot_rest.controller;

import com.project.spring_boot_rest.model.User;
import com.project.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
