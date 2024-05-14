package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.hocphanservice.model.Khoa;
import vn.edu.iuh.fit.hocphanservice.model.Nganh;
import vn.edu.iuh.fit.hocphanservice.services.KhoaNganhService;

import java.util.List;

@RestController
public class KhoaNganhController {
    @Autowired
    private KhoaNganhService khoaNganhService;

    @GetMapping("/getKhoaById/{id}")
    public String getKhoaById(@PathVariable long id) {
        Khoa khoa = khoaNganhService.getKhoaById(id);
        return khoa == null ?
                "false"     //mã khoa không tồn tại
                : khoa.toString();
    }

    @GetMapping("/getNganhById/{id}")
    public String getNganhById(@PathVariable long id) {
        Nganh nganh = khoaNganhService.getNganhById(id);
        return nganh == null ?
                "false"     //mã ngành không tồn tại
                : nganh.toString();
    }

    @PostMapping("/createKhoa/{tenKhoa}")
    public String createKhoa(@PathVariable String tenKhoa) {
        Khoa khoa = khoaNganhService.createKhoa(tenKhoa);
        return khoa == null ?
                "false"     //tên khoa đã tồn tại
                : khoa.toString();
    }

    @PostMapping("/createNganh/{maKhoa}/{tenNganh}")
    public String createNganh(@PathVariable String tenNganh, @PathVariable long maKhoa) {
        Nganh nganh = khoaNganhService.createNganh(tenNganh, maKhoa);
        return nganh == null ?
                "false"     //tên ngành đã tồn tại hoặc mã khoa không tồn tại
                : nganh.toString();
    }

    @PostMapping("/updateTenKhoa/{maKhoa}/{tenKhoa}")
    public String updateTenKhoa(@PathVariable long maKhoa, @PathVariable String tenKhoa) {
        Khoa khoa = khoaNganhService.updateTenKhoa(maKhoa, tenKhoa);
        return khoa == null ?
                "false"     //mã khoa không tồn tại
                : khoa.toString();
    }

    @PostMapping("/updateTenNganh/{maNganh}/{tenNganh}")
    public String updateTenNganh(@PathVariable long maNganh, @PathVariable String tenNganh) {
        Nganh nganh = khoaNganhService.updateTenNganh(maNganh, tenNganh);
        return nganh == null ?
                "false"     //mã ngành không tồn tại
                : nganh.toString();
    }

    @PostMapping("/deleteKhoa/{id}")
    public String deleteKhoa(@PathVariable long id) {
        return !khoaNganhService.deleteKhoa(id) ?
                "false"     //khoa này còn ngành đang hoạt động
                : "true";
    }

    @PostMapping("/deleteNganh/{id}")
    public String deleteNganh(@PathVariable long id) {
        return !khoaNganhService.deleteNganh(id) ?
                "false"     //ngành này đã có học phần
                : "true";
    }

    @GetMapping("/getNganhByKhoa/{id}")
    public String getNganhByKhoa(@PathVariable long id) {
        List<Nganh> nganhList = khoaNganhService.getNganhByKhoa(id);
        return nganhList == null ?
                "false"     //mã khoa không tồn tại
                : nganhList.toString();
    }
}
