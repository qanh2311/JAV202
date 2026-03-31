package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.repository.BillRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillController {
    @Autowired
    BillRepo billRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("/bill")
    public String bill(Model model) {
        model.addAttribute("bills", billRepo.findAll());
        model.addAttribute("users", userRepo.findAll());
        return "bill";
    }

    @GetMapping("/detail-bill")
    public String detailBill(Model model, @RequestParam("id") Integer id) {
        Bill bill = billRepo.findById(id).orElse(null);
        model.addAttribute("b", bill);
        model.addAttribute("bills", billRepo.findAll());
        model.addAttribute("users", userRepo.findAll());
        return "bill-detail";
    }

    @PostMapping("/add-bill")
    public String addBill(Bill bill, Model model) {
        System.out.println(bill.toString());
        model.addAttribute("user", new Bill());
        billRepo.save(bill);
        return "redirect:/bill";
    }

    @GetMapping("/delete-bill")
    public String deleteBill(Bill bill) {
        billRepo.delete(bill);
        return "redirect:/bill";
    }

    @PostMapping("/update-bill")
    public String updateBill(Bill bill, Model model) {
        billRepo.save(bill);
        return "redirect:/update-bill";
    }
}
