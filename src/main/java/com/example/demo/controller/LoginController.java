package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @GetMapping("/login-form")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username")  String username,
            @RequestParam("password")  String password,
            //Truyền dự liệu qua 2 request
            RedirectAttributes redirectAttributes) {

        if ("admin".equals(username) && "admin".equals(password)) {
            //addFlashAttribute lưu thông tin tạm thời vào Session
            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("password", password);
            return "redirect:/list-user";

        } else{
            return "error.html";
        }
    }
}
