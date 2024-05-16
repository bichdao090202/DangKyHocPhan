package vn.edu.iuh.fit.ketquahoctapservice.ids;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class KetQuaHocKyId implements Serializable {
    private long maSinhVien;
    private int hocKy;

    public KetQuaHocKyId(long maSinhVien, int hocKy) {
        this.maSinhVien = maSinhVien;
        this.hocKy = hocKy;
    }


    public KetQuaHocKyId() {

    }
}
