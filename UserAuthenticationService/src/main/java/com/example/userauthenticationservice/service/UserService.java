package com.example.userauthenticationservice.service;

import com.example.userauthenticationservice.model.Nganh;
import com.example.userauthenticationservice.model.SinhVien;
import com.example.userauthenticationservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private GiangVienRepository giangVienRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private GiaoVuRepository giaoVuRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private NganhRepository nganhRepository;

    public Nganh createNganh(Nganh nganh) {
        return nganhRepository.save(nganh);
    }

    public SinhVien createSinhVien(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }


}
