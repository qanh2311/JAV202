package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login-form")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("/login")
    public void login(
            @RequestParam("username")  String username){
        System.out.println("Ban vua nhap vao: " + username);
    }
}
