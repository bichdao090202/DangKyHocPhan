package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.hocphanservice.services.KhoaNganhService;

@RestController
public class KhoaNganhController {
    @Autowired
    private KhoaNganhService khoaNganhService;

    @GetMapping("/getKhoaById/{id}")
    public String getKhoaById(@PathVariable long id) {
        return khoaNganhService.getKhoaById(id)==null?
                "false"     //mã khoa không tồn tại
                :"true";
    }

    @GetMapping("/getNganhById/{id}")
    public String getNganhById(@PathVariable long id) {
        return khoaNganhService.getNganhById(id)==null?
                "false"     //mã ngành không tồn tại
                :"true";
    }

    @PostMapping("/createKhoa/{tenKhoa}")
    public String createKhoa(@PathVariable String tenKhoa) {
        return khoaNganhService.createKhoa(tenKhoa)==null?
                "false"     //tên khoa đã tồn tại
                :"true";
    }

    @PostMapping("/createNganh/{maKhoa}/{tenNganh}")
    public String createNganh(@PathVariable String tenNganh, @PathVariable long maKhoa) {
        return khoaNganhService.createNganh(tenNganh, maKhoa)==null?
                "false"     //tên ngành đã tồn tại hoặc mã khoa không tồn tại
                :"true";
    }

    @PostMapping("/updateTenKhoa/{maKhoa}/{tenKhoa}")
    public String updateTenKhoa(@PathVariable long maKhoa, @PathVariable String tenKhoa) {
        return khoaNganhService.updateTenKhoa(maKhoa, tenKhoa)==null?
                "false"     //mã khoa không tồn tại
                :"true";
    }

    @PostMapping("/updateTenNganh/{maNganh}/{tenNganh}")
    public String updateTenNganh(@PathVariable long maNganh, @PathVariable String tenNganh) {
        return khoaNganhService.updateTenNganh(maNganh, tenNganh)==null?
                "false"     //mã ngành không tồn tại
                :"true";
    }

    @PostMapping("/deleteKhoa/{id}")
    public String deleteKhoa(@PathVariable long id) {
        return !khoaNganhService.deleteKhoa(id)?
                "false"     //khoa này còn ngành đang hoạt động
                :"true";
    }

    @PostMapping("/deleteNganh/{id}")
    public String deleteNganh(@PathVariable long id) {
        return !khoaNganhService.deleteNganh(id)?
                "false"     //ngành này đã có học phần
                :"true";
    }

    @GetMapping("/getNganhByKhoa/{id}")
    public String getNganhByKhoa(@PathVariable long id) {
        return khoaNganhService.getNganhByKhoa(id).toString();
    }
}
