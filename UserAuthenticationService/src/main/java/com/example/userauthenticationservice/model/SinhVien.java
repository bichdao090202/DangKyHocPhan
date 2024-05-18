package com.example.userauthenticationservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class SinhVien {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_sinh_vien")
//    @SequenceGenerator(name = "seq_ma_sinh_vien", sequenceName = "seq_ma_sinh_vien", initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen_sinh_vien")
    @TableGenerator(name = "table_gen_sinh_vien", table = "id_gen_sinh_vien", pkColumnName = "gen_name_sinh_vien", valueColumnName = "gen_val_sinh_vien", initialValue = 10000, allocationSize = 50)
    private long maSinhVien;
    private String ten;
    private int khoa;
    private String email;
    private boolean totNghiep;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @ManyToOne
    @JoinColumn(name = "tenDangNhap")
    private TaiKhoan taiKhoan;

    public SinhVien(String ten, int khoa, long maNganh) {
        this.ten = ten;
        this.khoa = khoa;
        this.nganh = new Nganh(maNganh);
    }

    public SinhVien(long mssv) {
        this.maSinhVien = mssv;
    }


}
