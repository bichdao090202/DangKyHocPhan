package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "nganh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nganh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maNganh;
    private String tenNganh;
    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;
    @OneToMany( mappedBy = "nganh", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HocPhan> hocPhanList;
    @OneToMany(mappedBy = "nganh", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SinhVien> sinhVienList;

    public Nganh(long maNganh) {
        this.maNganh = maNganh;
    }

    public Nganh(String tenNganh, Khoa khoa) {
        this.tenNganh = tenNganh;
        this.khoa = khoa;
    }
}
