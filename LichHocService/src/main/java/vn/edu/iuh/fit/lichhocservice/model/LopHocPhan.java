package vn.edu.iuh.fit.lichhocservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class LopHocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maLopHocPhan;
    private int soLuongHienTai;
    private int soLuongToiDa;
    @ManyToOne @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;
    @ManyToOne @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;
    @OneToMany @JoinColumn(name = "maLichHoc")
    private List<LichHoc> lichHoc;

    public LopHocPhan(long maLopHocPhan) {
        this.maLopHocPhan = maLopHocPhan;
    }

    public LopHocPhan(long maHocPhan, int soLuongToiDa) {
        this.hocPhan = new HocPhan(maHocPhan);
        this.soLuongHienTai = 0;
        this.soLuongToiDa = soLuongToiDa;
    }

    public LopHocPhan(long maHocPhan, long maGiangVien, int soLuongToiDa) {
        this.hocPhan = new HocPhan(maHocPhan);
        this.giangVien = new GiangVien(maGiangVien);
        this.soLuongHienTai = 0;
        this.soLuongToiDa = soLuongToiDa;
    }

    public LopHocPhan(long maHocPhan, long maGiangVien,long maLopHocPhan, int soLuongToiDa) {
        this.hocPhan = new HocPhan(maHocPhan);
        this.giangVien = new GiangVien(maGiangVien);
        this.soLuongHienTai = 0;
        this.soLuongToiDa = soLuongToiDa;
    }








}
