package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);

        return "register";
    }
}
