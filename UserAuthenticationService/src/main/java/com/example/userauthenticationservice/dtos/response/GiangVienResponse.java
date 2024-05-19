package com.example.userauthenticationservice.dtos.response;

import com.example.userauthenticationservice.model.GiangVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GiangVienResponse {
    private long maGiangVien;
    private String tenGiangVien;
    private long maNganh;

    public GiangVienResponse(GiangVien giangVien) {
        this.maGiangVien = giangVien.getMaGiangVien();
        this.tenGiangVien = giangVien.getTenGiangVien();
        this.maNganh = giangVien.getNganh().getMaNganh();
    }
}
