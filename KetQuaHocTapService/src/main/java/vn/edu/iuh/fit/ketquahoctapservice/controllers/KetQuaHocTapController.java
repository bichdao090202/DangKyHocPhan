package vn.edu.iuh.fit.ketquahoctapservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.DiemLopHocPhanRequest;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.res.KetQuaHocTapSinhVienDetail;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.services.KetQuaHocTapService;

import java.util.List;

@RestController
@RequestMapping("/KetQuaHocTap")
@CrossOrigin("*")
public class KetQuaHocTapController {
    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;

    @PostMapping("/nhapDiemChoLopHocPhan")
    public List<Long> nhapDiemChoLopHocPhan(@RequestBody DiemLopHocPhanRequest diemLopHocPhanRequest) {
        List<Long> danhSachMSSVDiemKhongHopLe = ketQuaHocTapService.nhapDiemChoLopHocPhan(diemLopHocPhanRequest);
        return danhSachMSSVDiemKhongHopLe;
    }

    @GetMapping("/getKetQuaSinhVien/{maSinhVien}")
    public KetQuaHocTapSinhVienDetail getKetQuaSinhVien(@PathVariable long maSinhVien) {
        System.out.println(maSinhVien);
        return ketQuaHocTapService.getKetQuaSinhVien(maSinhVien);
    }
}
