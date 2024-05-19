package vn.edu.iuh.fit.ketquahoctapservice.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.HocPhanRequest;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class HocPhan {
    @Id
    private long maHocPhan;
    private String tenHocPhan;
    private int soTinChi;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;

    /*
        Học phần có Nganh khác null là môn chỉ học trong ngành đó
        Học phần có Khoa khác null là môn chỉ học trong khoa đó
        Học phần có Nganh và Khoa null là môn đại cương của trường
     */

    public HocPhan(HocPhanRequest hocPhanRequest){
        this.maHocPhan = hocPhanRequest.getMaHocPhan();
        this.tenHocPhan = hocPhanRequest.getTenHocPhan();
        this.soTinChiLyThuyet = hocPhanRequest.getSoTinChiLyThuyet();
        this.soTinChiThucHanh = hocPhanRequest.getSoTinChiThucHanh();
        this.soTinChi = hocPhanRequest.getSoTinChiLyThuyet() + hocPhanRequest.getSoTinChiThucHanh();
    }

    public HocPhan(long maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public HocPhan(long maHocPhan, String tenHocPhan, int soTinChiLyThuyet, int soTinChiThucHanh) {
        this.maHocPhan = maHocPhan;
        this.tenHocPhan = tenHocPhan;
        this.soTinChiLyThuyet = soTinChiLyThuyet;
        this.soTinChiThucHanh = soTinChiThucHanh;
        this.soTinChi = soTinChiLyThuyet + soTinChiThucHanh;
    }


}
