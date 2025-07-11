package com.example.project_1.service;

import com.example.project_1.api.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public boolean authenticateUser(@RequestParam String accountId, @RequestParam String password) {
        var a = userRepo.findByAccountid(accountId);

        return a.stream().anyMatch(u -> u.getPassword().equals(password));
    }

    public boolean authenticateUserNative(@RequestParam String accountId, @RequestParam String password) {
        var a = userRepo.authenticateUserNative(accountId, password);
        return a != null && !a.isEmpty();
    }
}
