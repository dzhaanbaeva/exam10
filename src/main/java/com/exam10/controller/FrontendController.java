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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
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
    public String mainPage(Model model, Pageable pageable, HttpServletRequest uriBuilder, Principal principal) {
        var place = placeService.findAllPlace(pageable);
        var uri = uriBuilder.getRequestURI();
        var placeModel = model.addAttribute("place", placeService.findAll());
        PageableExample.constructPageable(place, propService.getDefaultPageSize(), placeModel, uri);

        if (principal != null) {
            String user = principal.getName();
            model.addAttribute("user", user);
            model.addAttribute("review", reviewRepository.findAll());
            return "index";
        }
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

    @GetMapping("/addPlace")
    public String addPlace(Model model, Principal principal) {
        String user = principal.getName();
        model.addAttribute("user", user);
        return "addPlace";
    }

    @PostMapping("/addPlace")
    public String addPlace(@RequestParam("name") String name, @RequestParam("description") String description,
                             @RequestParam("photo") MultipartFile photo) throws IOException {
        File photoFile = new File("src/main/resources/static/images/" + photo.getOriginalFilename());
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(photo.getBytes());
        os.close();

        String place = placeService.addPlace(name, description, photo.getOriginalFilename());

        return "redirect:/";
    }

    @GetMapping("/pagePlace/{id}")
    public String pagePlace(@PathVariable("id") int id, Model model, Principal principal) {

        var place = placeRepository.findById(id);
        var review = reviewRepository.findAll();
        String user = principal.getName();
        model.addAttribute("place", place);
        model.addAttribute("review", review);
        model.addAttribute("user", user);
        return "pagePlace";
    }
}
