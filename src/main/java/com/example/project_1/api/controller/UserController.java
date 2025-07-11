package com.example.project_1.api.controller;

import com.example.project_1.api.model.User;
import com.example.project_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public boolean getUser(@RequestParam String accountId, @RequestParam String password) {
        return userService.authenticateUser(accountId, password);
    }

    @GetMapping("/userNative")
    public boolean getUserNative(@RequestParam String accountId, @RequestParam String password) {
        return userService.authenticateUserNative(accountId, password);
    }
}
