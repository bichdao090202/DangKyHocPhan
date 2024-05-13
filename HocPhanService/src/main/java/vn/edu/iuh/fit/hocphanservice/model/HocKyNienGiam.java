package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class HocKyNienGiam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ma;
    @ManyToOne @JoinColumn(name = "maNganh")
    private Nganh nganh;
    private int khoa; // Khóa học
    private int hocKy;
    private int soTinChi;
    @ManyToOne @JoinColumn(name = "maNhomHocPhanTuChon")
    private NhomHocPhanTuChon nhomHocPhanTuChon;
    @OneToMany @JoinColumn(name = "maHocKy")
    private List<HocPhanTheoNienGiam> hocPhanTheoNienGiam;

    public HocKyNienGiam(long maNganh, int khoa, int hocKy) {
        this.khoa = khoa;
        this.hocKy = hocKy;
    }

    public HocKyNienGiam(long ma) {
    }

    @Override
    public String toString() {
        return "HocKyNienGiam{" +
                "ma=" + ma +
                ", nganh=" + nganh +
                ", khoa=" + khoa +
                ", hocKy=" + hocKy +
                ", soTinChi=" + soTinChi +
                ", nhomHocPhanTuChon=" + nhomHocPhanTuChon +
                ", hocPhanTheoNienGiam=" + hocPhanTheoNienGiam +
                '}';
    }
}
