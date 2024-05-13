package vn.edu.iuh.fit.lichhocservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class LichHoc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maLichHoc;
    private LocalDate ngayHoc;
    private int tietBatDau;
    private int tietKetThuc;
    private int nhomThucHanh;
    @ManyToOne @JoinColumn(name = "maPhong")
    private PhongHoc phongHoc;
    @ManyToOne @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
    @ManyToOne @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;

public LichHoc(LocalDate ngayHoc, int tietBatDau, int nhomThucHanh) {
        this.ngayHoc = ngayHoc;
        this.tietBatDau = tietBatDau;
        this.tietKetThuc = tietBatDau+2;
        this.nhomThucHanh = nhomThucHanh;
    }

    public LichHoc(long maLichHoc){
        this.maLichHoc = maLichHoc;
    }



}
