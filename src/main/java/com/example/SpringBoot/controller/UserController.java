package com.example.SpringBoot.controller;

import com.example.SpringBoot.model.User;
import com.example.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

//    @GetMapping("/{id}")
//    public String showUser(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.getOneUser(id));
//        return "oneUser";
//    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getOneUser(id));
        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
