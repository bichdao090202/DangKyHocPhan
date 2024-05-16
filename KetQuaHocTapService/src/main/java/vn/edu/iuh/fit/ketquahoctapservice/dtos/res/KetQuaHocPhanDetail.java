package vn.edu.iuh.fit.ketquahoctapservice.dtos.res;

import lombok.*;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KetQuaHocPhanDetail {
    private List<Double> listDiem;
    private double ketQuaHeSo;
    private String ketQuaChu;
    private String xepLoai;
    private boolean quaMon;
    private long maHocPhan;
    private String tenHocPhan;

    public KetQuaHocPhanDetail(KetQuaHocPhan ketQuaHocPhan) {
        listDiem = new ArrayList<>();
        System.out.println(ketQuaHocPhan);
        this.listDiem.add(ketQuaHocPhan.getThuongKy1());
        this.listDiem.add(ketQuaHocPhan.getThuongKy2());
        this.listDiem.add(ketQuaHocPhan.getThuongKy3());
        this.listDiem.add(ketQuaHocPhan.getGiuaKy());
        this.listDiem.add(ketQuaHocPhan.getThucHanh1());
        this.listDiem.add(ketQuaHocPhan.getThucHanh2());
        this.listDiem.add(ketQuaHocPhan.getThucHanh3());
        this.listDiem.add(ketQuaHocPhan.getCuoiKy());
        this.ketQuaHeSo = Math.round(ketQuaHocPhan.getKetQuaHeSo() * 100.0) / 100.0;
        this.ketQuaChu = ketQuaHocPhan.getKetQuaChu();
        this.xepLoai = ketQuaHocPhan.getXepLoai();
        this.quaMon = ketQuaHocPhan.isQuaMon();
        this.maHocPhan = ketQuaHocPhan.getHocPhan().getMaHocPhan();
        this.tenHocPhan = ketQuaHocPhan.getHocPhan().getTenHocPhan();
    }

    @Override
    public String toString() {
        return "{" +
                "listDiem=" + listDiem +
                ", ketQuaHeSo=" + ketQuaHeSo +
                ", ketQuaChu='" + ketQuaChu + '\'' +
                ", xepLoai='" + xepLoai + '\'' +
                ", quaMon=" + quaMon +
                ", maHocPhan=" + maHocPhan +
                ", tenHocPhan='" + tenHocPhan + '\'' +
                '}';
    }
}
