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
//        "ten": "Lập trình thiết bị di động",
//        "maNganh": 3,
//        "maKhoa": null,
//        "soTinChiLyThuyet": 3,
//        "soTinChiThucHanh": 1
//    }
    @PostMapping("/createHocPhan")
    public String createHocPhan(@RequestBody HocPhanRequest hocPhanRequest) {
        if (hocPhanRequest.getMaNganh() != 0 && hocPhanRequest.getMaKhoa() != 0)
            return "false";     //chỉ được set 1 trong 2 mã ngành hoặc mã khoa
        HocPhan hocPhan = hocPhanService.createHocPhan(hocPhanRequest);
        if (hocPhan == null)
            return "false";  // mã ngành hoặc mã khoa không tồn tại
        return hocPhan.toString();
    }

    @GetMapping("/getHocPhanById/{id}")
    public String getHocPhanById(@PathVariable long id) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        if (hocPhan == null)
            return "false";      // không tìm thấy id
        return hocPhan.toString();
    }

    @PostMapping("/deleteHocPhan")
    public String deleteHocPhan(@RequestParam long id) {
        if (!hocPhanService.deleteHocPhan(id))
            return "false";     // không tìm thấy id hoặc học phần đã được sử dụng
        return "true";
    }

    @PostMapping("/createHocPhanTienQuyet")
    public String createHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        HocPhanTienQuyet hocPhanTienQuyet = hocPhanService.setHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (hocPhanTienQuyet == null)
            return "false";     //mã học phần không tồn tại hoặc đã tồn tại quan hệ
        return "true";
    }

    @GetMapping("/getDanhSachHocPhanTienQuyet/{id}")
    public String getHocPhanTienQuyet(@PathVariable long id) {
        List<HocPhanTienQuyet> hocPhanTienQuyetList = hocPhanService.getHocPhanTienQuyet(id);
        if (hocPhanTienQuyetList == null)
            return "false";     // không tìm thấy mã học phần
        return hocPhanTienQuyetList.toString();
    }

    @PostMapping("/deleteHocPhanTienQuyet")
    public String deleteHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        if (hocPhanService.deleteHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet))
            return "true";
        return "false";     // không tìm thấy mã học phần hoặc mã học phần tiên quyết
    }

    // {
    //     "maNganh": 3,
    //     "khoa": 16,
    //     "hocKy": 1,
    //     "hocPhanTheoNienGiam": [1, 2, 3] //Option
    // }
    @PostMapping("/createHocKyNienGiam")
    public String createHocKyNienGiam(@RequestBody HocKyNienGiamRequest hocKyNienGiamRequest) {
        HocKyNienGiam hocKyNienGiam = hocPhanService.createHocKyNienGiam(hocKyNienGiamRequest);
        if (hocKyNienGiam == null)
            return "false";     // đã tồn tại học kỳ niên giám
        return hocKyNienGiam.toString();
    }

    @PostMapping("/themHocPhanVaoNienGiam")
    public String themHocPhanVaoNienGiam(@RequestBody HocPhanTheoNienGiamRequest hocPhanTheoNienGiamRequest) {
        return hocPhanService.themHocPhanVaoNienGiam(hocPhanTheoNienGiamRequest) ? "true" : "false";
    }

    @GetMapping("/getNienGiamByNganhAndKhoa")
    public String getNienGiamByNganhAndKhoa(@RequestParam long maNganh, @RequestParam int khoa) {
        List<HocPhanTheoNienGiamResponse> hocKyNienGiam = hocPhanService.getNienGiamByNganhAndKhoa(maNganh, khoa);
        if (hocKyNienGiam == null)
            return "false";
        return hocKyNienGiam.toString();
    }


}
