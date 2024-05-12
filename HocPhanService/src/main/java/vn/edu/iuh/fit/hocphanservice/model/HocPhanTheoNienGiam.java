package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class HocPhanTheoNienGiam {
    @Id
    private Long id;
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;
//    @Id
//    @OneToOne
//    @JoinColumn(name = "id")
//    private HocPhan hocPhan;
    private int hocKy;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @ManyToOne
    @JoinColumn(name = "maNhomHocPhanTuChon")
    private NhomHocPhanTuChon nhomHocPhanTuChon;



}
