package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocKyNienGiamRequest;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocPhanRequest;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocPhanTheoNienGiamRequest;
import vn.edu.iuh.fit.hocphanservice.model.*;
import vn.edu.iuh.fit.hocphanservice.services.HocPhanService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/HocPhanService")
public class HocPhanController {
    @Autowired
    private HocPhanService hocPhanService;


    @GetMapping()
    public String HocPhanService(){
        return "HocPhanService";
    }
    @PostMapping("/createHocPhan")
    public String createHocPhan(@RequestBody HocPhanRequest hocPhanDto) {
        HocPhan hocPhan = new HocPhan(hocPhanDto.getTen(),
                hocPhanDto.getMaNganh() == 0 ? null : new Nganh(hocPhanDto.getMaNganh()),
                hocPhanDto.getMaKhoa() == 0 ? null : new Khoa(hocPhanDto.getMaKhoa()),
                hocPhanDto.getSoTinChiLyThuyet(),
                hocPhanDto.getSoTinChiThucHanh());
        return hocPhanService.createHocPhan(hocPhan).toString();
    }

    @GetMapping("/getHocPhanById/{id}")
    public String getHocPhanById(@PathVariable long id) {
        return hocPhanService.getHocPhanById(id).toString();
    }

    @PostMapping("/createHocPhanTienQuyet")
    public String createHocPhanTienQuyet(@RequestParam long maHocPhan, @RequestParam long maHocPhanTienQuyet) {
        HocPhanTienQuyet hocPhanTienQuyet = hocPhanService.createHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (hocPhanTienQuyet == null) {
            return "false";
        }
        return "true";
    }

    @GetMapping("/getHocPhanTienQuyet/{id}")
    public String getHocPhanTienQuyet(@PathVariable long id) {
        return hocPhanService.getHocPhanById(id).getHocPhanTienQuyet().toString();
    }

    @PostMapping("/createHocKyNienGiam")
    public String createHocKyNienGiam(@RequestBody HocKyNienGiamRequest hocKyNienGiamRequest) {
        HocKyNienGiam hocKyNienGiam = new HocKyNienGiam(hocKyNienGiamRequest.getMaNganh(), hocKyNienGiamRequest.getKhoa(), hocKyNienGiamRequest.getHocKy());
        return hocPhanService.createHocKyNienGiam(hocKyNienGiam) ;
    }

    /*
    Tạo học kỳ niên giám và danh sách học phần theo niên giám
    Học kỳ đã tồn tại return false
     */
    @PostMapping("/createHocKyNienGiamAndListHocPhan")
    public String createHocKyNienGiamAndListHocPhan(@RequestBody HocKyNienGiamRequest hocKyNienGiamRequest){
        HocKyNienGiam hocKyNienGiam = new HocKyNienGiam(hocKyNienGiamRequest.getMaNganh(),hocKyNienGiamRequest.getKhoa(),hocKyNienGiamRequest.getHocKy());
        if (hocPhanService.createHocKyNienGiam(hocKyNienGiam).equals("false")){
            return "false";
        };
        List<HocPhanTheoNienGiam> hocPhanTheoNienGiamList = new ArrayList<>();
        for (Long t :  hocKyNienGiamRequest.getHocPhanTheoNienGiam()) {
            HocPhanTheoNienGiam tmp = new HocPhanTheoNienGiam(new HocPhan(t),hocKyNienGiam);
            hocPhanService.themHocPhanVaoNienGiam(tmp);
            hocPhanTheoNienGiamList.add(tmp);
        }
        hocKyNienGiam.setHocPhanTheoNienGiam(hocPhanTheoNienGiamList);
        return hocKyNienGiam.toString();
    }


    @GetMapping("/getHocPhanTheoNienGiamByNganhAndKhoa/{maNganh}/{khoa}")
    public String getHocPhanTheoNienGiamByNganhAndKhoa(@PathVariable long maNganh, @PathVariable int khoa) {
        return hocPhanService.findHocPhanTheoNienGiamByNganhAndKhoa(maNganh, khoa).toString();
    }

    @PostMapping("/themHocPhanVaoNienGiam")
    public String themHocPhanVaoNienGiam(@RequestBody HocPhanTheoNienGiamRequest hocPhanTheoNienGiamRequest) {
        HocPhanTheoNienGiam hocPhanTheoNienGiam = new HocPhanTheoNienGiam(hocPhanTheoNienGiamRequest.getMaHocPhan(), hocPhanTheoNienGiamRequest.getMaHocKyNienGiam());
        if (hocPhanService.themHocPhanVaoNienGiam(hocPhanTheoNienGiam) == null) {
            return "false";
        }
        return "true";
    }
}
