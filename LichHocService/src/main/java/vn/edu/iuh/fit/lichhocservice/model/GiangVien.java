package vn.edu.iuh.fit.lichhocservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "giang_vien")
@Getter
@Setter
@ToString
public class GiangVien {
    @Id
    private long maGiangVien;
    private String tenGiangVien;
    @OneToMany(mappedBy = "giangVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LichHoc> lichHocList;
    @OneToMany(mappedBy = "giangVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LopHocPhan> lopHocPhanList;

public GiangVien(long maGiangVien) {
        this.maGiangVien = maGiangVien;
    }






}
