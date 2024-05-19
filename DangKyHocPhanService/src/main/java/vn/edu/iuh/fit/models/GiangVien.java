package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.dtos.request.GiangVienRequest;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "giang_vien")
@Getter
@Setter
@ToString
public class GiangVien {
    @Id
    private long maGiangVien;
    private String tenGiangVien;
    @OneToMany(mappedBy = "giangVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LichHoc> lichHocList;
    @OneToMany(mappedBy = "giangVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LopHocPhan> lopHocPhanList;
    @ManyToOne @JoinColumn(name = "maNganh")
    private Nganh nganh;

    public GiangVien(long maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public GiangVien(GiangVienRequest giangVienRequest){
        this.tenGiangVien = giangVienRequest.getTenGiangVien();
        this.maGiangVien = giangVienRequest.getMaGiangVien();
        this.nganh = new Nganh(giangVienRequest.getMaNganh());
    }


}
