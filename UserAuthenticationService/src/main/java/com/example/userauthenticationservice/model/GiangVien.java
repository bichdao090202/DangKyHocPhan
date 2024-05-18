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
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ma_giang_vien")
//    @SequenceGenerator(name = "seq_ma_giang_vien", sequenceName = "seq_ma_giang_vien", initialValue = 5000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen_giang_vien")
    @TableGenerator(name = "table_gen_giang_vien", table = "id_gen_giang_vien", pkColumnName = "gen_name_giang_vien", valueColumnName = "gen_val_giang_vien", initialValue = 5000, allocationSize = 50)
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
