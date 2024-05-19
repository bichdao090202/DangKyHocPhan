package com.example.userauthenticationservice.dtos.request;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SinhVienRequest {
    private String tenSinhVien;
    private int khoa;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private long maNganh;
    private String soTaiKhoanNganHang;

    public SinhVienRequest(String tenSinhVien, int khoa, long maNganh, String email) {
        this.tenSinhVien = tenSinhVien;
        this.khoa = khoa;
        this.email = email;
        this.maNganh = maNganh;
    }
}
