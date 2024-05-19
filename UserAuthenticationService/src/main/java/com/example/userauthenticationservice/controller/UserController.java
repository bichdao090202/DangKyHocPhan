package com.example.userauthenticationservice.controller;

import com.example.userauthenticationservice.dtos.request.GiangVienRequest;
import com.example.userauthenticationservice.dtos.request.GiaoVuRequest;
import com.example.userauthenticationservice.dtos.request.SinhVienRequest;
import com.example.userauthenticationservice.model.GiangVien;
import com.example.userauthenticationservice.model.GiaoVu;
import com.example.userauthenticationservice.model.Nganh;
import com.example.userauthenticationservice.model.SinhVien;
import com.example.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createSinhVien")
    public SinhVien createSinhVien(@RequestBody SinhVienRequest sinhVienRequest){
        return userService.createSinhVien(sinhVienRequest);
    }

    @PostMapping("/createGiangVien")
    public GiangVien createGiangVien(@RequestBody GiangVienRequest giangVienRequest){
        return userService.createGiangVien(giangVienRequest);
    }

    @PostMapping("/createGiaoVu")
    public GiaoVu createGiangVien(@RequestBody GiaoVuRequest giaoVuRequest){
        return userService.createGiaoVu(giaoVuRequest);
    }

    @PostMapping("/createNganh")
    public void createBanSaoNganh(@RequestBody Nganh nganh){
        userService.createBanSaoNganh(nganh);
    }

    @GetMapping("/dangNhap/{tenDangNhap}/{matKhau}")
    public Object dangNhap(@PathVariable Long tenDangNhap,@PathVariable String matKhau) {
        return userService.dangNhap(tenDangNhap, matKhau);
    }

}
