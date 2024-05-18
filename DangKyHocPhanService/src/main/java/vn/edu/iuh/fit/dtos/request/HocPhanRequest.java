package vn.edu.iuh.fit.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class HocPhanRequest {
    private String tenHocPhan;
    private long maNganh;
    private long maKhoa;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;

}
