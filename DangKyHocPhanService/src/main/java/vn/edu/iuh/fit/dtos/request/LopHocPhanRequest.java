package vn.edu.iuh.fit.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LopHocPhanRequest {
    private long maHocPhan;
    private long maGiangVien;
    private LocalDate ngayMoDangKy;

}
