package vn.edu.iuh.fit.ketquahoctapservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class HocPhan {
    @Id
    private long maHocPhan;
    private long maLopHocPhan;
    private String ten;
    private int soTinChi;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;
    private boolean thucHanh;

    /*
        Học phần có Nganh khác null là môn chỉ học trong ngành đó
        Học phần có Khoa khác null là môn chỉ học trong khoa đó
        Học phần có Nganh và Khoa null là môn đại cương của trường
     */
    public HocPhan(String ten, int soTinChiLyThuyet, int soTinChiThucHanh, long maLopHocPhan) {
        this.ten = ten;
        this.soTinChiLyThuyet = soTinChiLyThuyet;
        this.soTinChiThucHanh = soTinChiThucHanh;
        this.soTinChi = soTinChiLyThuyet + soTinChiThucHanh;
        this.thucHanh = soTinChiThucHanh > 0;
        this.maLopHocPhan = maLopHocPhan;
    }


    public HocPhan(long maHocPhan) {
        this.maHocPhan = maHocPhan;
    }
}
