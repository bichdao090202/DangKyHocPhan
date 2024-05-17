package vn.edu.iuh.fit.lichhocservice.model;

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
    private String ten;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;
    private int hocKy;
    private boolean batBuoc;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private Nganh nganh;
    @OneToMany(mappedBy = "hocPhan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LopHocPhan> lopHocPhanList;

}
