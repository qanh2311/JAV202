package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    public Integer id;

    public String email;

    public String password;

    public String fullname;

    public Double luong;

    public String diaChi;

    public Boolean active;
}
