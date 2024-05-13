package vn.edu.iuh.fit.lichhocservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class PhongHoc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maPhong;
    private String tenPhong;
    private boolean phongLyThuyet;

    public PhongHoc(long maPhong) {
        this.maPhong = maPhong;
    }
}
