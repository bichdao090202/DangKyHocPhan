package com.example.userauthenticationservice.model;

import com.example.userauthenticationservice.dtos.request.GiangVienRequest;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class GiangVien {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_giang_vien")
//    @SequenceGenerator(name = "seq_ma_giang_vien", sequenceName = "seq_ma_giang_vien", initialValue = 5000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen_giang_vien")
    @TableGenerator(name = "table_gen_giang_vien", table = "id_gen_giang_vien", pkColumnName = "gen_name_giang_vien", valueColumnName = "gen_val_giang_vien", initialValue = 5000, allocationSize = 50)
    private long maGiangVien;
    private String tenGiangVien;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String soAtm;

    @ManyToOne
    private Nganh nganh;
    @OneToOne
    @JoinColumn(name = "maGiangVien")
    private TaiKhoan taiKhoan;


    public GiangVien(String tenGiangVien, long maNganh) {
        this.tenGiangVien = tenGiangVien;
        this.nganh = new Nganh(maNganh);
    }

    public GiangVien(long maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public GiangVien (GiangVienRequest giangVienRequest) {
        this.tenGiangVien = giangVienRequest.getTenGiangVien();
        this.ngaySinh = giangVienRequest.getNgaySinh();
        this.gioiTinh = giangVienRequest.getGioiTinh();
        this.diaChi = giangVienRequest.getDiaChi();
        this.soDienThoai = giangVienRequest.getSoDienThoai();
        this.email = giangVienRequest.getEmail();
        this.soCCCD = giangVienRequest.getSoCCCD();
        this.soAtm = giangVienRequest.getSoTaiKhoanNganHang();
        this.nganh = new Nganh(giangVienRequest.getMaNganh());
    }

}
