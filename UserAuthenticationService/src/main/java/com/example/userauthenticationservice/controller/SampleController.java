package com.example.userauthenticationservice.controller;

import com.example.userauthenticationservice.dtos.request.GiangVienRequest;
import com.example.userauthenticationservice.dtos.request.GiaoVuRequest;
import com.example.userauthenticationservice.dtos.request.SinhVienRequest;
import com.example.userauthenticationservice.model.*;
import com.example.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("SampleController")
public class SampleController {
    @Autowired
    private UserService userService;

    @GetMapping("/createSample1")
    public List<SinhVien> createSample1() {
        Nganh nganhcntt = new Nganh(1, "Cong nghe thong tin");
        Nganh nganhkt = new Nganh(2, "Ke toan");
        List<SinhVien> sinhViens = new ArrayList<>();
        userService.createBanSaoNganh(nganhcntt);
        userService.createBanSaoNganh(nganhkt);
        SinhVien sinhVien1= userService.createSinhVien(new SinhVienRequest("Nguyen Van A", 16,1,"A@gmail.com"));
        SinhVien sinhVien2= userService.createSinhVien(new SinhVienRequest("Nguyen Van B", 16,1,"B@gmail.com"));
        SinhVien sinhVien3= userService.createSinhVien(new SinhVienRequest("Nguyen Van C", 16,1,"C@gmail.com"));
        SinhVien sinhVien4= userService.createSinhVien(new SinhVienRequest("Nguyen Van D", 16,1,"D@gmail.com"));
        SinhVien sinhVien5= userService.createSinhVien(new SinhVienRequest("Nguyen Van D", 16,1,"D@gmail.com"));
        SinhVien sinhVien6= userService.createSinhVien(new SinhVienRequest("Nguyen Van D", 16,1,"D@gmail.com"));
        sinhViens.add(sinhVien1);
        sinhViens.add(sinhVien2);
        sinhViens.add(sinhVien3);
        sinhViens.add(sinhVien4);
        sinhViens.add(sinhVien5);
        sinhViens.add(sinhVien6);
        return sinhViens;
    }

    @GetMapping("/createSample2")
    public List<Object> createSample2() {
        List<Object> objects = new ArrayList<>();
        GiangVienRequest giangVien1 = new GiangVienRequest("Giang vien 1", 1);
        GiangVienRequest giangVien2 = new GiangVienRequest("Giang vien 2", 2);
        GiangVienRequest giangVien3 = new GiangVienRequest("Giang vien 3", 1);
        objects.add(userService.createGiangVien(giangVien1));
        objects.add(userService.createGiangVien(giangVien2));
        objects.add(userService.createGiangVien(giangVien3));
        objects.add(userService.createGiaoVu(new GiaoVuRequest("Giao vu 1")));
        return objects;
    }
}
