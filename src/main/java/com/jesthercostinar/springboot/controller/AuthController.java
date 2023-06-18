package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.dto.UserDto;
import com.jesthercostinar.springboot.entity.User;
import com.jesthercostinar.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    // handler method to handle login request
    @GetMapping("/login")
    public String login() {
        return "login";
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
    public String registrationFormSave(@Valid @ModelAttribute("user") UserDto userDto,
                                       BindingResult result,
                                       Model model) {
        User existing = userService.findUserByEmail(userDto.getEmail());

        if (existing != null && existing.getEmail() != null && !existing.getEmail().isEmpty()) {
            result.rejectValue("email", null, "Email already exist");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);

        return "redirect:/register?success";
    }

    // handler method to handle list of User
    @GetMapping("users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "users";
    }
}
