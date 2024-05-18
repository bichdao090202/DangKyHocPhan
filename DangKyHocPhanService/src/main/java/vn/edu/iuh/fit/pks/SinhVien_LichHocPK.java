package vn.edu.iuh.fit.pks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien_LichHocPK implements Serializable {
    private long maSV;
    private long maLichHoc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien_LichHocPK that)) return false;
        return getMaSV() == that.getMaSV() && getMaLichHoc() == that.getMaLichHoc();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaSV(), getMaLichHoc());
    }
}
