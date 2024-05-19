package vn.edu.iuh.fit.dtos.response;

import lombok.*;
import vn.edu.iuh.fit.models.HocPhan;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HocPhanResponse {
    private long maHocPhan;
    private String tenHocPhan;
    private int soTinChiLythuyet;
    private int soTinChiThuchanh;
    private boolean batBuoc;

    public HocPhanResponse(HocPhan hocPhan){
        this.maHocPhan = hocPhan.getMaHocPhan();
        this.tenHocPhan = hocPhan.getTenHocPhan();
        this.soTinChiLythuyet = hocPhan.getSoTinChiLyThuyet();
        this.soTinChiThuchanh = hocPhan.getSoTinChiThucHanh();
    }


}
