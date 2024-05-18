package vn.edu.iuh.fit.ketquahoctapservice.dtos.res;


import lombok.*;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KetQuaHocKySinhVien {
    private int hocKy;
    private List<KetQuaHocPhanDetail> ketQuaHocPhanDetailRespons = new ArrayList<>();
    private double diemTrungBinh;
    private int soTinChiTichLuy;
    private String xepLoai;

    public KetQuaHocKySinhVien(KetQuaHocKy ketQuaHocKy) {
        this.hocKy = ketQuaHocKy.getId().getHocKy();
        for (KetQuaHocPhan ketQuaHocPhan : ketQuaHocKy.getKetQuaHocPhans()) {
            ketQuaHocPhanDetailRespons.add(new KetQuaHocPhanDetail(ketQuaHocPhan));
        }
        this.diemTrungBinh = Math.round(ketQuaHocKy.getDiemTrungBinh() * 100.0) / 100.0;
        this.soTinChiTichLuy = ketQuaHocKy.getSoTinChiTichLuy();
        this.xepLoai = ketQuaHocKy.getXepLoai();
    }

    @Override
    public String toString() {
        return "{" +
                "hocKy=" + hocKy +
                ", ketQuaHocPhanDetailRespons=" + ketQuaHocPhanDetailRespons +
                ", diemTrungBinh=" + diemTrungBinh +
                ", soTinChiTichLuy=" + soTinChiTichLuy +
                ", xepLoai='" + xepLoai + '\'' +
                '}';
    }
}
