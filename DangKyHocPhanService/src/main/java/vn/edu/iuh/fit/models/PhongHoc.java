package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phong_hoc")
@Getter
@Setter
@ToString
public class PhongHoc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maPhong;
    private String tenPhong;
    private boolean phongLyThuyet;
    @OneToMany( mappedBy = "phongHoc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LichHoc> lichHocList;

    public PhongHoc(long maPhong) {
        this.maPhong = maPhong;
    }
}
