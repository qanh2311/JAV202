package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Drink;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DrinkController {
    @Autowired
    DrinkRepo drinkRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @GetMapping("/drink")
    public String home(Model model) {
        List<Category> listCategory = categoryRepo.findAll();
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("drinks", drinkRepo.findAll());
        return "drink";
    }

    @PostMapping("/add-drink")
    public String addDrink(Drink drink, Model model) {
        System.out.println(drink.toString());
        model.addAttribute("category", new Category());
        drinkRepo.save(drink);
        return "redirect:/drink";
    }
}
