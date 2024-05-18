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
public class SinhVien_HocPhanPK implements Serializable {
    private long maSV;
    private long maHocPhan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien_HocPhanPK that)) return false;
        return getMaSV() == that.getMaSV() && getMaHocPhan() == that.getMaHocPhan();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaSV(), getMaHocPhan());
    }
}
