package com.example.userauthenticationservice.dtos.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GiaoVuRequest {
    private String tenGiaoVu;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String soTaiKhoanNganHang;

    public GiaoVuRequest(String tenGiaoVu) {
        this.tenGiaoVu = tenGiaoVu;
    }
}
