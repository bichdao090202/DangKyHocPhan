package com.example.userauthenticationservice.controller;

import com.example.userauthenticationservice.model.Nganh;
import com.example.userauthenticationservice.model.SinhVien;
import com.example.userauthenticationservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Sample")
public class SampleController {
    @Autowired
    private UserService userService;

    @GetMapping("/createSample1")
    public String createSample1() {
        Nganh nganhcntt = new Nganh(1, "Cong nghe thong tin");
        Nganh nganhkt = new Nganh(2, "Ke toan");
        userService.createNganh(nganhcntt);
        userService.createNganh(nganhkt);
        userService.createSinhVien(new SinhVien("Nguyen Van A", 16,1));
        userService.createSinhVien(new SinhVien("Nguyen Van B", 17,2));
        return "Create sample 1 successfully";
    }

}
