package vn.edu.iuh.fit.lichhocservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String tenSV;
    private String email;
    private String diaChi;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @OneToMany(mappedBy = "maSV")
    @JsonIgnore
    private List<SinhVien_LichHoc> sinhVienLichHocList;
}
