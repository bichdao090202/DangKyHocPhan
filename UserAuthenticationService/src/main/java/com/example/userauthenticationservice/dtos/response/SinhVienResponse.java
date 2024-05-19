package com.example.userauthenticationservice.dtos.response;

import com.example.userauthenticationservice.model.SinhVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SinhVienResponse {
    private long maSinhVien;
    private long maNganh;
    private int khoa;

    public SinhVienResponse(SinhVien sinhVien) {
        this.maSinhVien = sinhVien.getMaSinhVien();
        this.maNganh = sinhVien.getNganh().getMaNganh();
        this.khoa = sinhVien.getKhoa();
    }

}
