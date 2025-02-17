package com.Festify.EventManagement.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Festify.EventManagement.model.UserRegister;
import com.Festify.EventManagement.repository.RegistrationRepository;

@Service
public class UserService {
    private RegistrationRepository userRepo;
    private AuthenticationProvider authprovider;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(RegistrationRepository userRepo, AuthenticationProvider authprovider) {
        this.userRepo = userRepo;
        this.authprovider = authprovider;
    }

    public void getUserDetail(UserRegister newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        newUser.setRole("USER");
        userRepo.save(newUser);
    }

    public String verify(UserRegister newUser) {
        Authentication authentication = authprovider.authenticate(new UsernamePasswordAuthenticationToken(newUser.getEmail(), newUser.getPassword()));
        if (authentication.isAuthenticated()) {
            System.out.println("logged in");
        }
        throw new RuntimeException("authentication failed");
    }
}
