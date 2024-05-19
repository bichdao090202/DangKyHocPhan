package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.dtos.request.GiangVienRequest;
import vn.edu.iuh.fit.dtos.request.SinhVienRequest;
import vn.edu.iuh.fit.services.UserService;

@RestController
@RequestMapping("SaoChep")
public class SaoChepController {
    @Autowired
    private UserService userService;

    @PostMapping("/createSinhVien")
    public void createSinhVien(@RequestBody SinhVienRequest sinhVienRequest) {
        userService.createSinhVien(sinhVienRequest);
    }

    @PostMapping("/createGiangVien")
    public void createGiangVien(@RequestBody GiangVienRequest giangVienRequest) {
        userService.createGiangVien(giangVienRequest);
    }


}
