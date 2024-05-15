package vn.edu.iuh.fit.ketquahoctapservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class KetQuaHocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maKetQuaHocPhan;
    private double thuongKy1;
    private double thuongKy2;
    private double thuongKy3;
    private double giuaKy;
    private double thucHanh1;
    private double thucHanh2;
    private double ThucHanh3;
    private double cuoiKy;
    private double ketQuaHeSo;
    private String xepLoai;
    private boolean hocLai;
    @OneToOne @JoinColumn(name = "maLopHocPhan")
    private HocPhan hocPhan;
    private String maSinhVien;


}
