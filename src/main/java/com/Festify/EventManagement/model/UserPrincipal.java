package com.Festify.EventManagement.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{
    private UserRegister theUser;
    public UserPrincipal(UserRegister theUser) {
        this.theUser = theUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return theUser.getPassword();
    }

    @Override
    public String getUsername() {
        return theUser.getEmail();
    }

}
