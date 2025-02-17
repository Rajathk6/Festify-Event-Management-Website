package com.Festify.EventManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Festify.EventManagement.model.UserRegister;
import com.Festify.EventManagement.service.UserService;

@Controller
public class UserController {
    UserService userServe;
    public UserController(UserService userServe) {
        this.userServe = userServe;
    }

    @PostMapping("/signup")
    public String UserDetail(@ModelAttribute UserRegister newUser) {
        userServe.getUserDetail(newUser);
        return "redirect:/";
    }

    @PostMapping("/signin")
    public String userlogin(@ModelAttribute UserRegister newUser) {
        userServe.verify(newUser);
        return "redirect:/";
    }
}
