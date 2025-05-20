package com.example.runverse.controller;

import com.example.runverse.dto.LoginRequest;
import com.example.runverse.dto.LoginResponse;
import com.example.runverse.model.User;

import com.example.runverse.service.AuthService;
import com.example.runverse.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



import com.example.runverse.dto.SignupRequest;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private JwtUtil jwtUtil;



    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
