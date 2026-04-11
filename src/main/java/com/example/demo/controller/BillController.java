package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.repository.BillRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/bill/show")
    public String bill(Model model,
                       @RequestParam("page") Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Bill> bills = billRepo.findAll(pageable);
        model.addAttribute("bills", bills);
        model.addAttribute("users", userRepo.findAll());
        return "bill";
    }

    @GetMapping("/bill/detail-bill")
    public String detailBill(Model model, @RequestParam("id") Integer id) {
        Bill bill = billRepo.findById(id).orElse(null);
        model.addAttribute("b", bill);
        model.addAttribute("bills", billRepo.findAll());
        model.addAttribute("users", userRepo.findAll());
        return "bill-detail";
    }

    @PostMapping("/bill/add-bill")
    public String addBill(Bill bill, Model model) {
        System.out.println(bill.toString());
        model.addAttribute("user", new Bill());
        billRepo.save(bill);
        return "redirect:/bill/show?page=0";
    }

    @GetMapping("/bill/delete-bill")
    public String deleteBill(Bill bill) {
        billRepo.delete(bill);
        return "redirect:/bill/show?page=0";
    }

    @PostMapping("/bill/update-bill")
    public String updateBill(Bill bill, Model model) {
        billRepo.save(bill);
        return "redirect:/bill/show?page=0";
    }
}
