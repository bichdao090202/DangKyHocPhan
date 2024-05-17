package vn.edu.iuh.fit.lichhocservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
}
