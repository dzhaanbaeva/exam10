package com.exam10.controller;


import com.exam10.model.PageableExample;
import com.exam10.model.Review;
import com.exam10.model.User;
import com.exam10.repository.PlaceRepository;
import com.exam10.repository.ReviewRepository;
import com.exam10.repository.UserRepository;
import com.exam10.service.PlaceService;
import com.exam10.service.PropertiesService;
import com.exam10.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {
    private PlaceRepository placeRepository;
    private ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private PlaceService placeService;
    private PropertiesService propService;


    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/")
    public String mainPage(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
       var place = placeService.findAllPlace(pageable);
        var uri = uriBuilder.getRequestURI();
        var placeModel = model.addAttribute("place", placeService.findAll());
        PageableExample.constructPageable(place,propService.getDefaultPageSize(),placeModel,uri);
        model.addAttribute("review", reviewRepository.findAll());
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
