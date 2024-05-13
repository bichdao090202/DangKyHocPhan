package vn.edu.iuh.fit.lichhocservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class GiangVien {
    @Id
    private long maGiangVien;
    private String tenGiangVien;

public GiangVien(long maGiangVien) {
        this.maGiangVien = maGiangVien;
    }






}
