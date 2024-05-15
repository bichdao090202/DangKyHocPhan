package vn.edu.iuh.fit.ketquahoctapservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.DiemLopHocPhanRequest;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.services.KetQuaHocTapService;

import java.util.List;

@RestController
@RequestMapping("/KetQuaHocTap")
public class KetQuaHocTapController {
    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;

    // {
    //     "maHocPhan": 1,
    //     "maSinhVien": 1,
    //     "listDiem": [10, 9, 8, 7, 6]     5 cột là môn chỉ có lý thuyết, 8 cột là môn có thực hành
    // }
    @PostMapping("/nhapDiemChoSinhVien")
    public String nhapDiemChoSinhVien(@RequestBody DiemLopHocPhanRequest diemLopHocPhanRequest) {
        KetQuaHocPhan ketQuaHocPhan = ketQuaHocTapService.nhapDiemChoSinhVien(diemLopHocPhanRequest.getListKetQuaSinhVien().get(0), diemLopHocPhanRequest.getMaHocPhan());
        return ketQuaHocPhan == null ?
                "false"     // mã học phần không tồn tại hoặc điểm không hợp lệ
                : ketQuaHocPhan.toString();
    }

    @PostMapping("/nhapDiemChoLopHocPhan")
    public String nhapDiemChoLopHocPhan(@RequestBody DiemLopHocPhanRequest diemLopHocPhanRequest) {
        List<Long> danhSachMSSVDiemKhongHopLe = ketQuaHocTapService.nhapDiemChoLopHocPhan(diemLopHocPhanRequest);
        if (danhSachMSSVDiemKhongHopLe == null)
            return "false";     // mã học phần không tồn tại
        return danhSachMSSVDiemKhongHopLe.isEmpty() ?
                "true"     // nhập điểm thành công
                : danhSachMSSVDiemKhongHopLe.toString();
    }



}
