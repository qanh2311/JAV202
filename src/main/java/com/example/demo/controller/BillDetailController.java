package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.model.BillDetail;
import com.example.demo.model.Drink;
import com.example.demo.repository.BillDetailRepo;
import com.example.demo.repository.BillRepo;
import com.example.demo.repository.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BillDetailController {
    @Autowired
    DrinkRepo drinkRepo;
    @Autowired
    BillDetailRepo billDetailRepo;
    @Autowired
    BillRepo billRepo;

    @GetMapping("/bill-detail")
    public String billDetail(Model model) {
        List<BillDetail> listBillDetails = billDetailRepo.findAll();
        model.addAttribute("billDetails", listBillDetails);
        model.addAttribute("drinks", drinkRepo.findAll());
        model.addAttribute("bills", billRepo.findAll());
        return "bill-detail";
    }

    @PostMapping("/add-bill-detail")
    public String addBillDetail(BillDetail billDetail, Model model) {
        System.out.println(billDetail.toString());
        model.addAttribute("bill", new Bill());
        model.addAttribute("drink", new Drink());
        billDetailRepo.save(billDetail);
        return "redirect:/bill-detail";
    }

    @GetMapping("/delete-bill-detail")
    public String deleteBillDetail(BillDetail billDetail) {
        billDetailRepo.delete(billDetail);
        return "redirect:/bill-detail";
    }

    @GetMapping("/detail-bill-detail")
    public String detailBillDetail(@RequestParam("id") Integer id, Model model) {
        BillDetail billDetail = billDetailRepo.findById(id).orElse(null);
        model.addAttribute("bd", billDetail);
        model.addAttribute("billDetails", billDetailRepo.findAll());
        model.addAttribute("drinks", drinkRepo.findAll());
        model.addAttribute("bills", billRepo.findAll());
        return "bill-detail-detail";
    }

    @PostMapping("/update-bill-detail")
    public String updateBillDetail(BillDetail billDetail) {
        billDetailRepo.save(billDetail);
        return "redirect:/bill-detail";
    }
}
