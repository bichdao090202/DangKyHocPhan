package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.dtos.request.SinhVienRequest;

import java.util.List;

@Entity
@Table(name = "sinh_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    @Id
    private long maSV;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    private int khoa;
    @OneToMany(mappedBy = "maSV")
    @JsonIgnore
    private List<SinhVien_LichHoc> sinhVienLichHocList;
    @OneToMany(mappedBy = "maSV")
    @JsonIgnore
    private List<HocPhanDaDangKy> hocPhanDaDangKyList;

    public SinhVien(SinhVienRequest sinhVienRequest){
        this.maSV = sinhVienRequest.getMaSinhVien();
        this.nganh = new Nganh(sinhVienRequest.getMaNganh());
        this.khoa = sinhVienRequest.getKhoa();
    }
}
