package com.Festify.EventManagement.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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
        newUser.setEmail(newUser.getEmail().toLowerCase());
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        newUser.setRole("USER");
        userRepo.save(newUser);
    }

    public void verify(UserRegister newUser) {
    System.out.println(newUser.getEmail());
    try {
        Authentication authentication = authprovider.authenticate(
            new UsernamePasswordAuthenticationToken(newUser.getEmail(), newUser.getPassword())
        );

        // Check if authentication was successful
        if (authentication.isAuthenticated()) {
            System.out.println("logged in");

            // Set the authentication in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    } catch (AuthenticationException ex) {
        // Handle authentication failure
        System.out.println("Authentication failed: " + ex.getMessage());
        throw new RuntimeException("Authentication failed", ex);
    }
}
}
