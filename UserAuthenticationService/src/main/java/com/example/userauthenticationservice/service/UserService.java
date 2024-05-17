package com.example.userauthenticationservice.service;

import com.example.userauthenticationservice.model.Nganh;
import com.example.userauthenticationservice.model.SinhVien;
import com.example.userauthenticationservice.model.TaiKhoan;
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
        SinhVien sv = sinhVienRepository.save(sinhVien);
        TaiKhoan tk = new TaiKhoan(sv.getMaSinhVien());
        taiKhoanRepository.save(tk);
        return sv;
    }

    public SinhVien dangNhap(long tenDangNhap, String matKhau) {
        TaiKhoan tk = taiKhoanRepository.findById(tenDangNhap).orElse(null);
        if (tk.getMatKhau().equals(matKhau)) {
            return sinhVienRepository.findById(tenDangNhap).orElse(null);
        }
        return null;
    }
}
