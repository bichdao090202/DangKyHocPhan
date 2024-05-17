package com.example.userauthenticationservice.model;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_giang_vien")
    @SequenceGenerator(name = "seq_ma_giang_vien", sequenceName = "seq_ma_giang_vien", initialValue = 5000)
    private long maGiangVien;
    private String tenGiangVien;
    @ManyToOne
    private Nganh nganh;

    public GiangVien(String tenGiangVien, long maNganh) {
        this.tenGiangVien = tenGiangVien;
        this.nganh = new Nganh(maNganh);
    }

    public GiangVien(long maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

}
