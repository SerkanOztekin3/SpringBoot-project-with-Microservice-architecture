package com.javatechie.service;

import com.javatechie.client.UserClient;
import com.javatechie.entity.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

   /*@Autowired
    private UserCredentialRepository repository;*/
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserClient userClient;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        userClient.saveUser(credential);
        return "user added to the system";
    }

    public String generateToken(UserCredential userCredential) {
        return jwtService.generateToken(userCredential);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
