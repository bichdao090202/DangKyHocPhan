package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocKyNienGiamRequest;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocPhanRequest;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocPhanTheoNienGiamRequest;
import vn.edu.iuh.fit.hocphanservice.dtos.res.HocPhanTheoNienGiamResponse;
import vn.edu.iuh.fit.hocphanservice.model.HocKyNienGiam;
import vn.edu.iuh.fit.hocphanservice.model.HocPhan;
import vn.edu.iuh.fit.hocphanservice.model.HocPhanTienQuyet;
import vn.edu.iuh.fit.hocphanservice.services.HocPhanService;

import java.util.List;

@RestController
@RequestMapping("/HocPhanService")
public class HocPhanController {
    @Autowired
    private HocPhanService hocPhanService;

    //    {
//        "tenHocPhan": "Lập trình thiết bị di động",
//        "maNganh": 3,
//        "maKhoa": null,
//        "soTinChiLyThuyet": 3,
//        "soTinChiThucHanh": 1
//    }
    @PostMapping("/createHocPhan")
    public HocPhan createHocPhan(@RequestBody HocPhanRequest hocPhanRequest) {
        if (hocPhanRequest.getMaNganh() != 0 && hocPhanRequest.getMaKhoa() != 0)
            return null;     //chỉ được set 1 trong 2 mã ngành hoặc mã khoa
        HocPhan hocPhan = hocPhanService.createHocPhan(hocPhanRequest);
        return hocPhan;
    }

    @GetMapping("/getHocPhanById/{id}")
    public HocPhan getHocPhanById(@PathVariable long id) {
        return hocPhanService.getHocPhanById(id);
    }

    @PostMapping("/deleteHocPhan")
    public boolean deleteHocPhan(@RequestParam long id) {
        return hocPhanService.deleteHocPhan(id);
    }

    @PostMapping("/createHocPhanTienQuyet")
    public HocPhanTienQuyet createHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        return hocPhanService.setHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
    }

    @GetMapping("/getDanhSachHocPhanTienQuyet/{id}")
    public List<HocPhanTienQuyet> getHocPhanTienQuyet(@PathVariable long id) {
        return hocPhanService.getHocPhanTienQuyet(id);
    }

    @PostMapping("/deleteHocPhanTienQuyet")
    public boolean deleteHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        return hocPhanService.deleteHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
    }

    // {
    //     "maNganh": 3,
    //     "khoa": 16,
    //     "hocKy": 1,
    //     "hocPhanTheoNienGiam": [1, 2, 3] //Option
    // }
    @PostMapping("/createHocKyNienGiam")
    public HocKyNienGiam createHocKyNienGiam(@RequestBody HocKyNienGiamRequest hocKyNienGiamRequest) {
        return hocPhanService.createHocKyNienGiam(hocKyNienGiamRequest);
    }

    @PostMapping("/themHocPhanVaoNienGiam")
    public boolean themHocPhanVaoNienGiam(@RequestBody HocPhanTheoNienGiamRequest hocPhanTheoNienGiamRequest) {
        return hocPhanService.themHocPhanVaoNienGiam(hocPhanTheoNienGiamRequest);
    }

    @GetMapping("/getNienGiamByNganhAndKhoa")
    public List<HocPhanTheoNienGiamResponse> getNienGiamByNganhAndKhoa(@RequestParam long maNganh, @RequestParam int khoa) {
        return hocPhanService.getNienGiamByNganhAndKhoa(maNganh, khoa);
    }
}
