package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class HocPhanTheoNienGiam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;
    @ManyToOne
    @JoinColumn(name = "maHocKyNienGiam")
    private HocKyNienGiam hocKyNienGiam;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "maNhomHocPhanTuChon")
    private NhomHocPhanTuChon nhomHocPhanTuChon;

    public HocPhanTheoNienGiam(HocPhan hocPhan, HocKyNienGiam hocKyNienGiam) {
        this.hocPhan = hocPhan;
        this.hocKyNienGiam = hocKyNienGiam;
    }

    public HocPhanTheoNienGiam(Long maHocPhan){
        this.hocPhan = new HocPhan(maHocPhan);
    }

    public HocPhanTheoNienGiam(long maHocPhan, long maHocKyNienGiam) {
        this.hocPhan = new HocPhan(maHocPhan);
        this.hocKyNienGiam = new HocKyNienGiam(maHocKyNienGiam);
    }

    @Override
    public String toString() {
        return "HocPhanTheoNienGiam{" +
                "id=" + id +
                ", hocPhan=" + hocPhan ;
//                ", hocKyNienGiam=" + hocKyNienGiam;
    }
}
