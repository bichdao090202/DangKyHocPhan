package vn.edu.iuh.fit.hocphanservice.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HocPhanRequest {
    private String ten;
    private long maNganh;
    private long maKhoa;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;

//    body example:
//    {
//        "ten": "Lập trình thiết bị di động",
//        "maNganh": 3,
//        "maKhoa": null,
//        "soTinChiLyThuyet": 3,
//        "soTinChiThucHanh": 1
//    }
}
