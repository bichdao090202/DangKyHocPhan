package vn.edu.iuh.fit.hocphanservice.dtos.res;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HocPhanTheoNienGiamResponse {
    private long maHocKyNienGiam;
    private int hocKy;

    private List<HocPhanResponse> danhSachHocPhan = new ArrayList<>();

    public void addHocPhanResponse(HocPhanResponse hocPhanResponse){
        this.danhSachHocPhan.add(hocPhanResponse);
    }

}
