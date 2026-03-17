package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

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

    @GetMapping("/list-user")
    public String listUser(Model model){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "anhptqth05962@gmail.com", "123456", "Phạm Thị Quỳnh Anh", "0337376926", true, true));
        users.add(new User(2, "anhptqth05962@gmail.com", "123456", "Phạm Thị Quỳnh Anh", "0337376926", true, false));
        users.add(new User(3, "anhptqth05962@gmail.com", "123456", "Phạm Thị Quỳnh Anh", "0337376926", false, true));
        users.add(new User(4, "anhptqth05962@gmail.com", "123456", "Phạm Thị Quỳnh Anh", "0337376926", true, true));
        users.add(new User(5, "anhptqth05962@gmail.com", "123456", "Phạm Thị Quỳnh Anh", "0337376926", true, true));
        // truyen danh sach user cho UI
        model.addAttribute("users", users);

        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        nhanViens.add(new NhanVien(1, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
        nhanViens.add(new NhanVien(2, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
        nhanViens.add(new NhanVien(3, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
        nhanViens.add(new NhanVien(4, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
        nhanViens.add(new NhanVien(5, "nhanvien1@gmail.com", "123456789", "Nguyen Van A", 30.000,"Cau Giay", true));
        model.addAttribute("lstNhanVien", nhanViens);
        return "index.html";
    }
}
