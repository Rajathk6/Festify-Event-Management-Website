package com.Festify.EventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Festify.EventManagement.model.UserRegister;

@Repository
public interface RegistrationRepository extends JpaRepository<UserRegister, Integer> {

    UserRegister findByMail(String email);
    
} 
