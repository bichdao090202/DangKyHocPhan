package com.example.userauthenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class TaiKhoan {
    @Id
    private long tenDangNhap;
    private String matKhau;


    public TaiKhoan(long tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
}
