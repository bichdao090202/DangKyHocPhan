package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.models.Khoa;
import vn.edu.iuh.fit.models.Nganh;
import vn.edu.iuh.fit.services.KhoaNganhService;

import java.util.List;

@RestController
public class KhoaNganhController {
    @Autowired
    private KhoaNganhService khoaNganhService;

    @GetMapping("/getKhoaById/{id}")
    public Khoa getKhoaById(@PathVariable long id) {
        return khoaNganhService.getKhoaById(id);
    }

    @GetMapping("/getNganhById/{id}")
    public Nganh getNganhById(@PathVariable long id) {
        return khoaNganhService.getNganhById(id);
    }

    @PostMapping("/createKhoa/{tenKhoa}")
    public Khoa createKhoa(@PathVariable String tenKhoa) {
        return khoaNganhService.createKhoa(tenKhoa);
    }

    @PostMapping("/createNganh/{maKhoa}/{tenNganh}")
    public Nganh createNganh(@PathVariable String tenNganh, @PathVariable long maKhoa) {
        return khoaNganhService.createNganh(tenNganh, maKhoa);
    }

    @PostMapping("/updateTenKhoa/{maKhoa}/{tenKhoa}")
    public Khoa updateTenKhoa(@PathVariable long maKhoa, @PathVariable String tenKhoa) {
        return khoaNganhService.updateTenKhoa(maKhoa, tenKhoa);
    }

    @PostMapping("/updateTenNganh/{maNganh}/{tenNganh}")
    public Nganh updateTenNganh(@PathVariable long maNganh, @PathVariable String tenNganh) {
        return khoaNganhService.updateTenNganh(maNganh, tenNganh);
    }

    @PostMapping("/deleteKhoa/{id}")
    public boolean deleteKhoa(@PathVariable long id) {
        return khoaNganhService.deleteKhoa(id);
    }

    @PostMapping("/deleteNganh/{id}")
    public boolean deleteNganh(@PathVariable long id) {
        return khoaNganhService.deleteNganh(id);
    }

    @GetMapping("/getNganhByKhoa/{id}")
    public List<Nganh> getNganhByKhoa(@PathVariable long id) {
       return khoaNganhService.getNganhByKhoa(id);
    }
}
