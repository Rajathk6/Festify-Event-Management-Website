package com.Festify.EventManagement.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Festify.EventManagement.model.UserRegister;
import com.Festify.EventManagement.repository.RegistrationRepository;

@Service
public class UserService {

    private final RegistrationRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(RegistrationRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegister newUser) {
        newUser.setEmail(newUser.getEmail().toLowerCase());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRole("USER");
        userRepo.save(newUser);
    }
}

    // Remove the verify() method

//     public void verify(UserRegister newUser) {
//     System.out.println(newUser.getEmail());
//     try {
//         Authentication authentication = authprovider.authenticate(
//             new UsernamePasswordAuthenticationToken(newUser.getEmail(), newUser.getPassword())
//         );

//         // Check if authentication was successful
//         if (authentication.isAuthenticated()) {
//             System.out.println("logged in");

//             // Set the authentication in the SecurityContext
//             SecurityContextHolder.getContext().setAuthentication(authentication);
//         }
//     } catch (AuthenticationException ex) {
//         // Handle authentication failure
//         System.out.println("Authentication failed: " + ex.getMessage());
//         throw new RuntimeException("Authentication failed", ex);
//     }
// }
