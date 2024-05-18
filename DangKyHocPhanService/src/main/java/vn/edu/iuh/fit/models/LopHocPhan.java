package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.dtos.request.LopHocPhanRequest;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lop_hoc_phan")
@Getter
@Setter
@ToString
public class LopHocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maLopHocPhan;
    private int soLuongHienTai;
    private int soLuongToiDa;
    @ManyToOne @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;
    @ManyToOne @JoinColumn(name = "maGiangVien")
    @JsonIgnore
    private GiangVien giangVien;
    @OneToMany(mappedBy = "lopHocPhan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LichHoc> lichHocList;
    private LocalDate ngayMoDangKy;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String tenLopHocPhan;

    public LopHocPhan(LopHocPhanRequest lopHocPhanRequest){
        this.hocPhan = new HocPhan(lopHocPhanRequest.getMaHocPhan());
        this.ngayMoDangKy = lopHocPhanRequest.getNgayMoDangKy();
        this.giangVien = new GiangVien(lopHocPhanRequest.getMaGiangVien());
    }

}
