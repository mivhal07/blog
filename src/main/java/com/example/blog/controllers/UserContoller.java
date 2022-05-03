package com.example.blog.controllers;

import com.example.blog.entities.User;
import com.example.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContoller {
    private final UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "thx za admina";
    }
}
