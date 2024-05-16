package vn.edu.iuh.fit.ketquahoctapservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.DiemLopHocPhanRequest;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.services.KetQuaHocTapService;

import java.util.List;

@RestController
@RequestMapping("/KetQuaHocTap")
public class KetQuaHocTapController {
    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;

    @PostMapping("/nhapDiemChoSinhVien")
    public String nhapDiemChoSinhVien(@RequestBody DiemLopHocPhanRequest diemLopHocPhanRequest) {
        KetQuaHocPhan ketQuaHocPhan = ketQuaHocTapService.nhapDiemChoSinhVien(diemLopHocPhanRequest.getListKetQuaSinhVien().get(0), diemLopHocPhanRequest.getMaHocPhan(),diemLopHocPhanRequest.getHocKy());
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

    @GetMapping("/getKetQuaSinhVien/{maSinhVien}")
    public String getKetQuaSinhVien(@PathVariable long maSinhVien) {
        List<KetQuaHocKy> ketQuaHocKyList = ketQuaHocTapService.getKetQuaSinhVien(maSinhVien);
        return ketQuaHocKyList==null?
                "false"     // mã sinh viên không tồn tại
                : ketQuaHocKyList.toString();
    }



}
