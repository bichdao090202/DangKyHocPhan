package com.example.userauthenticationservice.model;

import com.example.userauthenticationservice.dtos.request.SinhVienRequest;
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
    private String tenSinhVien;
    private int khoa;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String soTaiKhoanNganHang;
    private boolean totNghiep;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @OneToOne
    @JoinColumn(name = "maSinhVien")
    private TaiKhoan taiKhoan;

    public SinhVien(String tenSinhVien, int khoa, long maNganh) {
        this.tenSinhVien = tenSinhVien;
        this.khoa = khoa;
        this.nganh = new Nganh(maNganh);
    }

    public SinhVien(long mssv) {
        this.maSinhVien = mssv;
    }

    public SinhVien(SinhVienRequest sinhVienRequest) {
        this.tenSinhVien = sinhVienRequest.getTenSinhVien();
        this.khoa = sinhVienRequest.getKhoa();
        this.ngaySinh = sinhVienRequest.getNgaySinh();
        this.gioiTinh = sinhVienRequest.getGioiTinh();
        this.diaChi = sinhVienRequest.getDiaChi();
        this.soDienThoai = sinhVienRequest.getSoDienThoai();
        this.email = sinhVienRequest.getEmail();
        this.soCCCD = sinhVienRequest.getSoCCCD();
        this.soTaiKhoanNganHang = sinhVienRequest.getSoTaiKhoanNganHang();
        this.nganh = new Nganh(sinhVienRequest.getMaNganh());
    }


}
