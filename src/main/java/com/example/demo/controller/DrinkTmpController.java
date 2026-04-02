package com.example.demo.controller;

import com.example.demo.model.DrinkTmp;
import com.example.demo.repository.DrinkTmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DrinkTmpController {
    @Autowired
    DrinkTmpRepo drinkTmpRepo;

    @GetMapping("/drink-tmp")
    public String drinkTmp(Model model){
        List<DrinkTmp> list = drinkTmpRepo.getList();
        model.addAttribute("list",list);
        return "drink-tmp";
    }
}
