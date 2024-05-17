package vn.edu.iuh.fit.lichhocservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "khoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKhoa;
    private String tenKhoa;
    @OneToMany( mappedBy = "khoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Nganh> nganhList;
}
