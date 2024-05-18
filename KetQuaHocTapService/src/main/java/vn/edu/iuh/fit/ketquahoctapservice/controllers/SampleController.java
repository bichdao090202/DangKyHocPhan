package vn.edu.iuh.fit.ketquahoctapservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.ketquahoctapservice.services.KetQuaHocTapService;

import java.util.List;

@RestController
@RequestMapping("/Sample")
public class SampleController {
    @Autowired
    HocPhanRepository hocPhanRepository;
    @Autowired
    KetQuaHocTapService ketQuaHocTapService;

    @GetMapping("/createSample1")
    public String createSample1() {
        HocPhan hocPhan1 = new HocPhan(1, "Tieng viet thuc han", 3, 0);
        HocPhan hocPhan2 = new HocPhan(2, "OOP", 2, 1);
        HocPhan hocPhan3 = new HocPhan(3, "WWW", 3, 1);
        hocPhanRepository.save(hocPhan1);
        hocPhanRepository.save(hocPhan2);
        hocPhanRepository.save(hocPhan3);
        return "Create sample 1 successfully";
    }

}
