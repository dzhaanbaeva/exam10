package com.exam10.controller;


import com.exam10.DTO.UserDTO;
import com.exam10.model.User;
import com.exam10.repository.UserRepository;
import com.exam10.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserRepository userRepository;


    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/add_employee")
    public String addEmployee(Model model, Principal principal){
        List<String> roles = userService.getRoles();
        model.addAttribute("users_roles", roles);
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        model.addAttribute("roles", userRepository.findByEmail(principal.getName()).getRoles().toString());

        return "add_employee";
    }


    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/employees")
    public String checkEmployees(Model model, Principal principal){
        var allUsers = userRepository.findAll();
        var user = userRepository.findByEmail(principal.getName());
        List<String> roles=new ArrayList<>();
        for (User users:allUsers) {
            roles.add(users.getRoles().toString().replace('[',' ').replace(']',' '));

        }
        model.addAttribute("employee", userRepository.findAll());
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        model.addAttribute("roles", userRepository.findByEmail(principal.getName()).getRoles().toString());
        model.addAttribute("testRoles",roles);
        return "users";
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/employee/{id}")
    public String singleGood(@PathVariable("id")int id, Model model, Principal principal){
        model.addAttribute("employee", UserDTO.from(userRepository.findById(id)));
//        model.addAttribute("store_names", sr.findByIdBetween(1,2));
        List<String> roles = userService.getRoles();
        model.addAttribute("users_roles", roles);
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        model.addAttribute("roles", userRepository.findByEmail(principal.getName()).getRoles().toString());
        var users2 = userRepository.findAllById(id);
        List<String> roles2=new ArrayList<>();
        for (User users:users2) {
            roles2.add(users.getRoles().toString().replace("[","").replace("]",""));

        }
        roles2.equals(roles);
        model.addAttribute("testRoles",roles2);
        return "single_employee";
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/change_employee")
    public String changeEmployee(
            @RequestParam(required = false, name = "user_role")String user_role,
            @RequestParam("user_id") int id,
            @RequestParam("fullname")String fullname, @RequestParam("email")String email,
            Model model, HttpSession session,Principal principal
    ) {
        session.getId();
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        model.addAttribute("roles", userRepository.findByEmail(principal.getName()).getRoles().toString());
        userService.updateUser(id,user_role, fullname, email);
        return "redirect:/employees";
    }


}
