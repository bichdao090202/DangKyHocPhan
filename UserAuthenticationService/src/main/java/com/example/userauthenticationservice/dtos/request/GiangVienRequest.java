package com.example.userauthenticationservice.dtos.request;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GiangVienRequest {
    private String tenGiangVien;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String maNganh;
    private String soTaiKhoanNganHang;

    public GiangVienRequest(String tenGiangVien, long maNganh) {
        this.tenGiangVien = tenGiangVien;
        this.maNganh = String.valueOf(maNganh);
    }
}
