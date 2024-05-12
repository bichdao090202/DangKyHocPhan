package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.*;

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
    private int soLuongYeuCau;

}
