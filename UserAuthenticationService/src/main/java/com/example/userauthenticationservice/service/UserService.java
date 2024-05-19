package com.example.userauthenticationservice.service;

import com.example.userauthenticationservice.dtos.request.GiangVienRequest;
import com.example.userauthenticationservice.dtos.request.GiaoVuRequest;
import com.example.userauthenticationservice.dtos.request.SinhVienRequest;
import com.example.userauthenticationservice.dtos.response.GiangVienResponse;
import com.example.userauthenticationservice.dtos.response.SinhVienResponse;
import com.example.userauthenticationservice.model.*;
import com.example.userauthenticationservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private RestTemplate restTemplate;
    private String urlDKHP = "http://localhost:9000/DangKyHocPhanService/SaoChep/";


    public SinhVien createSinhVien(SinhVienRequest sinhVienRequest){
        SinhVien sinhVien = new SinhVien(sinhVienRequest);
        sinhVienRepository.save(sinhVien);
        TaiKhoan tk = new TaiKhoan(sinhVien);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        SinhVienResponse sinhVienResponse = new SinhVienResponse(sinhVien);
        restTemplate.postForObject(urlDKHP+"createSinhVien", sinhVienResponse, Void.class);
        return sinhVien;
    }

    public GiangVien createGiangVien(GiangVienRequest giangVienRequest) {
        GiangVien giangVien = new GiangVien(giangVienRequest);
        giangVienRepository.save(giangVien);
        TaiKhoan tk = new TaiKhoan(giangVien);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        GiangVienResponse giangVienResponse = new GiangVienResponse(giangVien);
        restTemplate.postForObject(urlDKHP+"createGiangVien", giangVienResponse, Void.class);
        return giangVien;
    }

    public GiaoVu createGiaoVu(GiaoVuRequest giaoVuRequest) {
        GiaoVu giaoVu = new GiaoVu(giaoVuRequest);
        giaoVuRepository.save(giaoVu);
        TaiKhoan tk = new TaiKhoan(giaoVu);
        tk.setMatKhau(passwordEncoder.encode("1111"));
        taiKhoanRepository.save(tk);
        return giaoVu;
    }

    public Nganh createBanSaoNganh(Nganh nganh) {
        return nganhRepository.save(nganh);
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
