package vn.edu.iuh.fit.ketquahoctapservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class KetQuaHocKy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKetQuaHocKy;
    private long maSinhVien;
    private double diemTichLuy;
    private double diemTrungBinh;
    private int soTinChiTichLuy;
    private String xepLoai;
    private int hocKy;
    @OneToMany(mappedBy = "maSinhVien")
    List<KetQuaHocPhan> ketQuaHocPhans;

    public KetQuaHocKy(long maSinhVien, KetQuaHocPhan ketQuaHocPhan, int hocKy) {
        this.maSinhVien = maSinhVien;
        this.hocKy = hocKy;
        this.soTinChiTichLuy = ketQuaHocPhan.getHocPhan().getSoTinChi();
        this.diemTrungBinh = ketQuaHocPhan.getKetQuaHeSo();
        this.diemTichLuy = ketQuaHocPhan.getKetQuaHeSo() * ketQuaHocPhan.getHocPhan().getSoTinChi();
        tinhXepLoai();
    }

    public void updateKeQuaHocKy(List<KetQuaHocPhan> ketQuaHocPhanList) {
        this.diemTichLuy = 0;
        this.soTinChiTichLuy = 0;
        for (KetQuaHocPhan ketQuaHocPhan : ketQuaHocPhanList) {
            this.diemTichLuy += ketQuaHocPhan.getKetQuaHeSo() * ketQuaHocPhan.getHocPhan().getSoTinChi();
            this.soTinChiTichLuy += ketQuaHocPhan.getHocPhan().getSoTinChi();
        }
        this.diemTrungBinh = diemTichLuy / this.soTinChiTichLuy;
        tinhXepLoai();
    }

    private void tinhXepLoai() {
        double trungBinh = this.diemTrungBinh;
        this.diemTrungBinh = trungBinh;
        if (trungBinh >= 9) {
            this.xepLoai = "Xuất sắc";
        } else if (trungBinh >= 8) {
            this.xepLoai = "Giỏi";
        } else if (trungBinh >= 7) {
            this.xepLoai = "Khá";
        } else if (trungBinh >= 5) {
            this.xepLoai = "Trung bình";
        } else {
            this.xepLoai = "Yếu";
        }
    }

}
