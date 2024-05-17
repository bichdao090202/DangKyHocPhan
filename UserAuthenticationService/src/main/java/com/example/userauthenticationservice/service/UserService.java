package com.example.userauthenticationservice.service;

import com.example.userauthenticationservice.model.*;
import com.example.userauthenticationservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Nganh createNganh(Nganh nganh) {
        return nganhRepository.save(nganh);
    }

    public SinhVien createSinhVien(SinhVien sinhVien) {
        SinhVien sv = sinhVienRepository.save(sinhVien);
        TaiKhoan tk = new TaiKhoan(sv.getMaSinhVien());
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return sv;
    }

    public GiangVien createGiangVien(GiangVien giangVien) {
        GiangVien gv = giangVienRepository.save(giangVien);
        TaiKhoan tk = new TaiKhoan(giangVien.getMaGiangVien());
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return gv;
    }

    public GiaoVu createGiaoVu(GiaoVu giaoVu) {
        GiaoVu gv = giaoVuRepository.save(giaoVu);
        TaiKhoan tk = new TaiKhoan(giaoVu.getMaGiaoVu());
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return gv;
    }

    public Object dangNhap(long tenDangNhap, String matKhau) {
        TaiKhoan tk = taiKhoanRepository.findById(tenDangNhap).orElse(null);
        if (tk == null) {
            throw new UsernameNotFoundException("Không tìm thấy tài khoản");
        }
        if (passwordEncoder.matches(matKhau, tk.getMatKhau())) {
            if (tenDangNhap>=10000)
                return sinhVienRepository.findById(tenDangNhap).orElse(null);
            if (tenDangNhap>=5000)
                return giangVienRepository.findById(tenDangNhap).orElse(null);
            return giaoVuRepository.findById(tenDangNhap).orElse(null);
        }
        return null;
    }
}
