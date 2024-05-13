package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class NhomHocPhanTuChon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maNhomHocPhanTuChon;
    private String tenNhomHocPhanTuChon;
    private int soLuongYeuCau;
    @OneToMany
    @JoinColumn(name = "maNhomHocPhanTuChon")
    private List<HocPhanTheoNienGiam> hocPhanTheoNienGiam;


}
