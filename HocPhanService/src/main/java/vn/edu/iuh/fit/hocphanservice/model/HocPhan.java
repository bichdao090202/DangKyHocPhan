package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class HocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maHocPhan;
    private String ten;
    @ManyToOne @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @ManyToOne @JoinColumn(name = "maKhoa")
    private Khoa khoa;
    private int soTinChi;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;
    @OneToMany @JoinColumn(name = "maHocPhan")
    private List<HocPhanTienQuyet> hocPhanTienQuyet;
    private boolean thucHanh;
    private boolean monDaiCuong;

    /*
        Học phần có Nganh khác null là môn chỉ học trong ngành đó
        Học phần có Khoa khác null là môn chỉ học trong khoa đó
        Học phần có Nganh và Khoa null là môn đại cương của trường
     */
    public HocPhan(String ten, Nganh nganh, Khoa khoa, int soTinChiLyThuyet, int soTinChiThucHanh) {
        this.ten = ten;
        this.nganh = nganh;
        this.khoa = khoa;
        this.soTinChiLyThuyet = soTinChiLyThuyet;
        this.soTinChiThucHanh = soTinChiThucHanh;
        this.soTinChi = soTinChiLyThuyet + soTinChiThucHanh;
        this.thucHanh = soTinChiThucHanh > 0;
        this.monDaiCuong = nganh == null && khoa == null;

    }

    public HocPhan(long id) {
        this.maHocPhan = id;
    }

    @Override
    public String toString() {
        return "HocPhan{" +
                "maHocPhan=" + maHocPhan +
                ", ten='" + ten + '\'' +
                ", nganh=" + nganh +
                ", khoa=" + khoa +
                ", soTinChi=" + soTinChi +
                ", soTinChiLyThuyet=" + soTinChiLyThuyet +
                ", soTinChiThucHanh=" + soTinChiThucHanh +
                ", thucHanh=" + thucHanh +
                ", monDaiCuong=" + monDaiCuong +
                '}';
    }

}
