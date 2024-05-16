package vn.edu.iuh.fit.hocphanservice.dtos.res;

import lombok.*;
import vn.edu.iuh.fit.hocphanservice.model.HocPhan;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HocPhanResponse {
    private long maHocPhan;
    private String ten;
    private int soTinChiLythuyet;
    private int soTinChiThuchanh;
    private int nhomThucHanh;
    private boolean batBuoc;
    private boolean ketQua;

    public HocPhanResponse(HocPhan hocPhan){
        this.maHocPhan = hocPhan.getMaHocPhan();
        this.ten = hocPhan.getTen();
        this.soTinChiLythuyet = hocPhan.getSoTinChiLyThuyet();
        this.soTinChiThuchanh = hocPhan.getSoTinChiThucHanh();
    }


}
