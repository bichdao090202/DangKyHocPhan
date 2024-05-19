package vn.edu.iuh.fit.dtos.response;

import lombok.*;
import vn.edu.iuh.fit.models.LopHocPhan;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LopHocPhanResponse {
    private long maLopHocPhan;
    private int soLuongHienTai;
    private int soLuongToiDa;
    private String tenHocPhan;
    private String tenGiangVien;
    private LocalDate ngayMoDangKy;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String tenLopHocPhan;

    public LopHocPhanResponse (LopHocPhan lopHocPhan){
        this.maLopHocPhan = lopHocPhan.getMaLopHocPhan();
        this.soLuongHienTai = lopHocPhan.getSoLuongHienTai();
        this.soLuongToiDa = lopHocPhan.getSoLuongToiDa();
        this.tenHocPhan = lopHocPhan.getHocPhan().getTenHocPhan();
        this.tenGiangVien = lopHocPhan.getGiangVien().getTenGiangVien();
        this.ngayMoDangKy = lopHocPhan.getNgayMoDangKy();
        this.ngayBatDau = lopHocPhan.getNgayBatDau();
        this.ngayKetThuc = lopHocPhan.getNgayKetThuc();
        this.tenLopHocPhan = lopHocPhan.getTenLopHocPhan();
    }
}
