package com.security.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring_security.entity.UserAuthEntity;
import com.security.spring_security.service.UserAuthService;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint to register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody UserAuthEntity user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userAuthService.saveUser(user);
        return "User registered successfully!";

    }

    @GetMapping("/")
    public String home() {
        return "Welcome user!";
    }
}