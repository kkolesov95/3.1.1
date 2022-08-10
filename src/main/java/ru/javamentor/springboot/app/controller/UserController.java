package ru.javamentor.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springboot.app.model.User;
import ru.javamentor.springboot.app.service.UserService;



@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "show";
    }

    @GetMapping("users/new")
    public String newUser(User user) {
        return "new";
    }

    @PostMapping("users")
    public String create(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "/edit";
    }

    @PostMapping("users/{id}")
    public String update(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
