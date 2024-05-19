package com.example.userauthenticationservice.model;

import com.example.userauthenticationservice.dtos.request.GiaoVuRequest;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class GiaoVu {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen_giao_vu")
    @TableGenerator(name = "table_gen_giao_vu", table = "id_gen_giao_vu", pkColumnName = "gen_name_giao_vu", valueColumnName = "gen_val_giao_vu", initialValue = 1000, allocationSize = 50)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_giao_vu")
//    @SequenceGenerator(name = "seq_ma_giao_vu", sequenceName = "seq_ma_giao_vu", initialValue = 1000)
    private long maGiaoVu;
    private String tenGiaoVu;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String soCCCD;
    private String soAtm;
    @OneToOne
    @JoinColumn(name = "maGiaoVu")
    private TaiKhoan taiKhoan;

    public GiaoVu(String tenGiaoVu) {
        this.tenGiaoVu = tenGiaoVu;
    }

    public GiaoVu(long maGiaoVu) {
        this.maGiaoVu = maGiaoVu;
    }

    public GiaoVu (GiaoVuRequest giaoVuRequest) {
        this.tenGiaoVu = giaoVuRequest.getTenGiaoVu();
        this.ngaySinh = giaoVuRequest.getNgaySinh();
        this.gioiTinh = giaoVuRequest.getGioiTinh();
        this.diaChi = giaoVuRequest.getDiaChi();
        this.soDienThoai = giaoVuRequest.getSoDienThoai();
        this.email = giaoVuRequest.getEmail();
        this.soCCCD = giaoVuRequest.getSoCCCD();
        this.soAtm = giaoVuRequest.getSoTaiKhoanNganHang();
    }
}
