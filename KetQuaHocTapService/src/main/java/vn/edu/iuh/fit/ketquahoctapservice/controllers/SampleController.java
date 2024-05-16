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

    @GetMapping("/createSample2")
    public String createSample2() {
        List<Double> listDiem1 = List.of(5.0, 6.0, 7.0, 8.0, 9.0);
        KetQuaSinhVien ketQuaSinhVien1 = new KetQuaSinhVien(1, listDiem1);
        List<Double> listDiem2 = List.of(5.0, 5.0, 5.0, 5.0, 9.0, 9.0, 9.0, 7.0);
        KetQuaSinhVien ketQuaSinhVien2 = new KetQuaSinhVien(2, listDiem2);
        // 10 10 10 10 5 5 5 10
        List<Double> listDiem3 = List.of(10.0, 10.0, 10.0, 10.0, 5.0, 5.0, 5.0, 10.0);
        KetQuaSinhVien ketQuaSinhVien3 = new KetQuaSinhVien(3, listDiem3);
        ketQuaHocTapService.nhapDiemChoSinhVien(ketQuaSinhVien1, 1, 1);
        ketQuaHocTapService.nhapDiemChoSinhVien(ketQuaSinhVien2, 2, 1);
        ketQuaHocTapService.nhapDiemChoSinhVien(ketQuaSinhVien3, 3, 2);
        return "Create sample 2 successfully";
    }

}
