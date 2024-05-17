package com.example.userauthenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

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
