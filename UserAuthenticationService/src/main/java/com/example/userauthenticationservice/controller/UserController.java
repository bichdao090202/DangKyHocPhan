package com.example.userauthenticationservice.controller;

import com.example.userauthenticationservice.model.Nganh;
import com.example.userauthenticationservice.model.SinhVien;
import com.example.userauthenticationservice.model.TaiKhoan;
import com.example.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createSample1")
    public List<SinhVien> createSample1() {
        Nganh nganhcntt = new Nganh(1, "Cong nghe thong tin");
        Nganh nganhkt = new Nganh(2, "Ke toan");
        List<SinhVien> sinhViens = new ArrayList<>();
        userService.createNganh(nganhcntt);
        userService.createNganh(nganhkt);
        SinhVien sinhVien1= new SinhVien("Nguyen Van A", 16,1);
        SinhVien sinhVien2= new SinhVien("Nguyen Van B", 17,2);
        userService.createSinhVien(sinhVien1);
        userService.createSinhVien(sinhVien2);
        sinhViens.add(sinhVien1);
        sinhViens.add(sinhVien2);
        return sinhViens;
    }

    @GetMapping("/dangNhap/{tenDangNhap}/{matKhau}")
    public SinhVien dangNhap(@PathVariable Long tenDangNhap,@PathVariable String matKhau) {
        return userService.dangNhap(tenDangNhap, matKhau);
    }


}
