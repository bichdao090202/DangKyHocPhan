package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoc_phan")
@Getter
@Setter
@ToString
public class HocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maHocPhan;
    private String tenHocPhan;
    private int soTinChi;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;
    @ManyToOne @JoinColumn(name = "maKhoa")
    private Khoa khoa;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @OneToMany(mappedBy = "hocPhan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LopHocPhan> lopHocPhanList;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "maHocPhan")
    @JsonIgnore
    private List<HocPhanTienQuyet> hocPhanTienQuyet;
    @OneToMany(mappedBy = "maHocPhan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HocPhanDaDangKy> hocPhanDaDangKyList;

    public HocPhan(String tenHocPhan, Nganh nganh, Khoa khoa, int soTinChiLyThuyet, int soTinChiThucHanh) {
        this.tenHocPhan = tenHocPhan;
        this.nganh = nganh;
        this.khoa = khoa;
        this.soTinChiLyThuyet = soTinChiLyThuyet;
        this.soTinChiThucHanh = soTinChiThucHanh;
        this.soTinChi = soTinChiLyThuyet + soTinChiThucHanh;
    }

    public HocPhan(long maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public HocPhan(HocPhan maHocPhan) {

    }
}
