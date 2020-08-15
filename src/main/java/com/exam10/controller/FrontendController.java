package com.exam10.controller;


import com.exam10.model.User;
import com.exam10.repository.UserRepository;
import com.exam10.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final UserRepository userRepository;
    private  final UserService userService;


    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/registration")
    public String createUser(@RequestParam("fullName") String name, @RequestParam("email") String email,
                           @RequestParam("password") String password) {

        String user = userService.addUser(name, email, password);

        return "redirect:/login";
    }

}
