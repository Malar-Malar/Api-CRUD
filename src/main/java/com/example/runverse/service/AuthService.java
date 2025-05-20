package com.example.runverse.service;

import com.example.runverse.dto.LoginRequest;
import com.example.runverse.dto.SignupRequest;
import com.example.runverse.model.User;
import com.example.runverse.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public String signup(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return " Email already registered!";

        }

        if (userRepository.existsByEmail(request.getEmail())) {
            return " Username already taken!";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return "Signup successful!";
    }



    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean passwordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!passwordMatch) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful! Welcome, " + user.getUsername();
    }
    }






