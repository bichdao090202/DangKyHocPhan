package vn.edu.iuh.fit.lichhocservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.lichhocservice.pks.SinhVien_LichHocPK;

@Entity
@Table(name = "sinh_vien-lich_hoc")
@IdClass(SinhVien_LichHocPK.class)
@Getter
@Setter
public class SinhVien_LichHoc {
    @Id
    @ManyToOne
    @JoinColumn(name = "maSV")
    private SinhVien maSV;
    @Id
    @ManyToOne
    @JoinColumn(name = "maLichHoc")
    private LichHoc maLichHoc;

    @Override
    public String toString() {
        return maSV.getMaSV() + maLichHoc.getMaLichHoc() + "";
    }
}
