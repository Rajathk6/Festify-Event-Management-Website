package com.Festify.EventManagement.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Festify.EventManagement.model.UserPrincipal;
import com.Festify.EventManagement.model.UserRegister;
import com.Festify.EventManagement.repository.RegistrationRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final RegistrationRepository singleUserRepo;
    
    public MyUserDetailService(RegistrationRepository singleUserRepo) {
        this.singleUserRepo = singleUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserRegister user = singleUserRepo.findByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found: " + email);
        }
        return new UserPrincipal(user);
    }
}

