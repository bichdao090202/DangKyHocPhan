package vn.edu.iuh.fit.ketquahoctapservice.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;

import java.util.List;

@Getter
@Setter
@ToString
public class DiemLopHocPhanRequest {
    private long maHocPhan;
    private int hocKy;
    private List<KetQuaSinhVien> listKetQuaSinhVien;

}
