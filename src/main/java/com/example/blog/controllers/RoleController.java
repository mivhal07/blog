package com.example.blog.controllers;

import com.example.blog.dao.RoleDao;
import com.example.blog.entities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
    private final RoleDao roleDao;

    public RoleController(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("role", new Role());
        return "role/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public String addResult(@Valid Role role, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        roleDao.createRole(role);
        return "Wszystko git, thanks";
    }

}
