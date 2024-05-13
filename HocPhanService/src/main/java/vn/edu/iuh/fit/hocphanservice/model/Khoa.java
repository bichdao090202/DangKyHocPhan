package vn.edu.iuh.fit.hocphanservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Khoa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maKhoa;
    private String tenKhoa;
    @OneToMany(mappedBy = "khoa")
    private List<Nganh> nganhs;

    public Khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public Khoa(long maKhoa) {
        this.maKhoa = maKhoa;

    }

    @Override
    public String toString() {
        return "Khoa{" +
                "maKhoa=" + maKhoa +
                ", tenKhoa='" + tenKhoa + '\'' +
                '}';
    }
}
