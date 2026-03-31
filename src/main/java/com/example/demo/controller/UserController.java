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
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);

        // 2. QUAN TRỌNG: Gửi 1 đối tượng User trống để cái Form ở đầu trang không bị lỗi
        model.addAttribute("user", new User());

        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("drinks", drinkRepo.findAll());
        model.addAttribute("billDetails", billDetailRepo.findAll());
        model.addAttribute("bills", billRepo.findAll());

        return "index.html";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        // Fetch from database instead of the empty ArrayList
        User result = userRepo.findById(id).orElse(null);

        if (result == null) {
            return "redirect:/list-user";
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

    @PostMapping("/save")
    public String save(User user
    ){
        userRepo.save(user);
        System.out.println(user);
        return "redirect:/list-user";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        userRepo.deleteById(id);
        return "redirect:/list-user";
    }

    @GetMapping("/delete-category")
    public String deleteCategory(@RequestParam("id") Integer id){
        categoryRepo.deleteById(id);
        return "redirect:/list-user";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category){
        categoryRepo.save(category);
        return "redirect:/list-user";
    }

    @GetMapping("/search-user")
    public String search(@RequestParam("fullname") String fullname, @RequestParam("role") Boolean role, Model model){
        List<User> users = userRepo.getByFullnameAndRole(fullname, role);
        model.addAttribute("users", users);

        // THÊM DÒNG NÀY: Để tránh lỗi null khi quay lại trang index
        model.addAttribute("user", new User());

        // Bổ sung các list khác để các bảng bên dưới không bị trống dữ liệu
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("drinks", drinkRepo.findAll());
        model.addAttribute("billDetails", billDetailRepo.findAll());
        model.addAttribute("bills", billRepo.findAll());

        return "index.html";
    }
}
