package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.dto.UserDto;
import com.jesthercostinar.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

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

    // handler method to handle user registration form requst

    @PostMapping("/register/save")
    public String registrationFormSave(@ModelAttribute("user") UserDto userDto) {
        userService.saveUser(userDto);

        return "redirect:/register?success";
    }
}
