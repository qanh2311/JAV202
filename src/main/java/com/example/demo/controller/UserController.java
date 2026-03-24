package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
//    @GetMapping("/login")
//    public String login(){
//        return "login.html";
//    }

    @GetMapping("/index")
    public String index(Model model){
        String name = "Pth Quynh Anh";
        String lop = "SD20308";
        Integer tuoi = 17;

        model.addAttribute("name", name);
        model.addAttribute("lop", lop);
        model.addAttribute("tuoi", tuoi);
        return "index.html";
    }

    ArrayList<User> users = new ArrayList<>();

    public UserController(){

    }

    @Autowired
    UserRepo userRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    BillDetailRepo billDetailRepo;
    @Autowired
    BillRepo  billRepo;
    @Autowired
    DrinkRepo drinkRepo;

    @GetMapping("/list-user")
    public String listUser(Model model){
        // truyen danh sach user cho UI
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);

        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);

        List<Drink> drinks = drinkRepo.findAll();
        model.addAttribute("drinks", drinks);

        List<BillDetail> billDetails = billDetailRepo.findAll();
        model.addAttribute("billDetails", billDetails);

        List<Bill> bills = billRepo.findAll();
        model.addAttribute("bills", bills);


//        ArrayList<NhanVien> nhanViens = new ArrayList<>();
//        nhanViens.add(new NhanVien(1, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
//        nhanViens.add(new NhanVien(2, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
//        nhanViens.add(new NhanVien(3, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
//        nhanViens.add(new NhanVien(4, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
//        nhanViens.add(new NhanVien(5, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
//        model.addAttribute("lstNhanVien", nhanViens);
        return "index.html";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam("id") Integer id ){
        User result = new User();
        for (User u : users){
            if(u.getId().equals(id)){
                result = u;
            }
        }
        model.addAttribute("user", result);
        return "user-detail.html";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam("phone") String phone){
        User result = new User();
        for (User u : users){
            if(u.getPhone().equals(phone)){
                result = u;
            }
        }
        model.addAttribute("user", result);
        return "user-detail.html";
    }
}
