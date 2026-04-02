package com.example.demo.controller;

import com.example.demo.model.UserTmp;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserTmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserTmpController {

    @Autowired
    UserTmpRepo userTmpRepo;

    @GetMapping("/user-tmp")
    public String getList(Model model) {
        List<UserTmp> list =  userTmpRepo.getList();
        model.addAttribute("list", list);
        return "user-tmp";
    }
}
