package vn.edu.iuh.fit.ketquahoctapservice.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HocPhanRequest {
    private long maHocPhan;
    private String tenHocPhan;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;

}
