package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.pks.SinhVien_LichHocPK;

@Entity
@Table(name = "sinh_vien-lich_hoc")
@IdClass(SinhVien_LichHocPK.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien_LichHoc {
    @Id
    @ManyToOne
    @JoinColumn(name = "maSV")
    private SinhVien maSV;
    @Id
    @ManyToOne
    @JoinColumn(name = "maLichHoc")
    private LichHoc maLichHoc;

}
