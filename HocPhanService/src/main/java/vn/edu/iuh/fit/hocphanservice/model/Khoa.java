package vn.edu.iuh.fit.hocphanservice.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Khoa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maKhoa;
    private String tenKhoa;
    @OneToMany(mappedBy = "khoa")
    private ArrayList<Nganh> nganhs;


}
