package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "khoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKhoa;
    private String tenKhoa;
    @OneToMany( mappedBy = "khoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Nganh> nganhList;

    public Khoa(long maKhoa) {
        this.maKhoa = maKhoa;
    }

    public Khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
