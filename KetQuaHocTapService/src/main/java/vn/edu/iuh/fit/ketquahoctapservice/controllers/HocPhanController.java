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
    public String createHocPhan(@RequestBody HocPhanRequest hocPhanRequest) {
        HocPhan hocPhan = hocPhanService.createHocPhan(new HocPhan(hocPhanRequest));
        return hocPhan.toString();
    }

    @PostMapping("/deleteHocPhan/{id}")
    public String deleteHocPhan(@PathVariable long id) {
        return hocPhanService.deleteHocPhan(id)? "true" : "false";
    }

    @GetMapping("/getHocPhanById/{id}")
    public String getHocPhanById(@PathVariable long id) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        return hocPhan==null? "false" : hocPhan.toString();
    }


}
