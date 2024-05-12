package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class HocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maHocPhan;
    private String ten;
    @ManyToOne @JoinColumn(name = "maNganh")
    private Nganh nganh;
    private int soTinChi;
    @ManyToOne @JoinColumn(name = "maHocPhanTienQuyet")
    private HocPhan[] hocPhanTienQuyet;
    private boolean tuChon;
    private boolean thucHanh;
    private LocalDate ngayDangKy;
    private boolean monDaiCuong;


}
