package com.example.userauthenticationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Nganh {
    @Id
    private long maNganh;
    private String tenNganh;

    public Nganh(long maNganh) {
        this.maNganh = maNganh;
    }
}
