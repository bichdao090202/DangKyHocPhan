package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class HocPhanTienQuyet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long ma;
    private long maHocPhan;
    private long maHocPhanTienQuyet;

    public HocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet) {
        this.maHocPhan = maHocPhan;
        this.maHocPhanTienQuyet = maHocPhanTienQuyet;
    }

    @Override
    public String toString() {
        return  maHocPhanTienQuyet + "";
    }


}