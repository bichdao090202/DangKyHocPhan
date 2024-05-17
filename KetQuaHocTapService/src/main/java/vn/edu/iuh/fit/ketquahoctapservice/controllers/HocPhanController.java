package vn.edu.iuh.fit.ketquahoctapservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.HocPhanRequest;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.services.HocPhanService;

@RestController
@RequestMapping("/HocPhan")
public class HocPhanController {
    @Autowired
    private HocPhanService hocPhanService;

    //    {
//        "maHocPhan": 1,
//        "tenHocPhan": "Lập trình thiết bị di động",
//        "soTinChiLyThuyet": 3,
//        "soTinChiThucHanh": 1
//    }
    @PostMapping("/createHocPhan")
    public HocPhan createHocPhan(@RequestBody HocPhanRequest hocPhanRequest) {
        return hocPhanService.createHocPhan(new HocPhan(hocPhanRequest));
    }

    @PostMapping("/deleteHocPhan/{id}")
    public boolean deleteHocPhan(@PathVariable long id) {
        return hocPhanService.deleteHocPhan(id);
    }

    @GetMapping("/getHocPhanById/{id}")
    public HocPhan getHocPhanById(@PathVariable long id) {
        return hocPhanService.getHocPhanById(id);
    }

}