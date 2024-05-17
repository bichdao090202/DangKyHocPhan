package com.example.userauthenticationservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class GiaoVu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_giao_vu")
    @SequenceGenerator(name = "seq_ma_giao_vu", sequenceName = "seq_ma_giao_vu", initialValue = 1000)
    private long maGiaoVu;
    private String tenGiaoVu;

    public GiaoVu(String tenGiaoVu) {
        this.tenGiaoVu = tenGiaoVu;
    }

    public GiaoVu(long maGiaoVu) {
        this.maGiaoVu = maGiaoVu;
    }
}
