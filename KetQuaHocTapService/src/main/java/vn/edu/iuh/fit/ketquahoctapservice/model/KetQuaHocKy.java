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
    private String maSinhVien;
    @OneToMany(mappedBy = "maSinhVien")
    List<KetQuaHocPhan> ketQuaHocPhans;
    private double diemTichLuy;
    private int soTinChiTichLuy;
    private String xepLoai;
    private int hocKy;

}
