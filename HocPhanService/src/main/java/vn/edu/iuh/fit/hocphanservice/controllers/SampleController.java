package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.hocphanservice.model.*;
import vn.edu.iuh.fit.hocphanservice.repositories.HocKyNienGiamRepository;
import vn.edu.iuh.fit.hocphanservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.hocphanservice.services.HocPhanService;
import vn.edu.iuh.fit.hocphanservice.services.KhoaNganhService;

@RestController
@RequestMapping("SampleController")
public class SampleController {
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private KhoaNganhService khoaNganhService;
    @Autowired
    private HocPhanRepository hocPhanRepository;
    @Autowired
    private HocKyNienGiamRepository hocKyNienGiamRepository;

    @GetMapping("/createDataSample1")
    public String createDataSample() {
        Khoa khoaCNTT = khoaNganhService.createKhoa("Cong nghe thong tin");
        if (khoaCNTT == null) {
            return "false";
        }
//        khoaNganhService.createNganh("Công nghệ thông tin", khoaCNTT.getMaKhoa());
//        khoaNganhService.createNganh("Hệ thống thông tin", khoaCNTT.getMaKhoa());
          khoaNganhService.createNganh("Ky thuat phan mem", khoaCNTT.getMaKhoa());
//        khoaNganhService.createNganh("Khoa học dữ liệu", khoaCNTT.getMaKhoa());
//        khoaNganhService.createNganh("An toàn thông tin", khoaCNTT.getMaKhoa());
//        khoaNganhService.createNganh("Khoa học máy tính", khoaCNTT.getMaKhoa());
//        hocPhanRepository.save(new HocPhan("Lập trình hướng đối tượng", null,new Khoa(1),2,1));
//        hocPhanRepository.save(new HocPhan("Cấu trúc dữ liệu và giải thuật", null,new Khoa(1),3,1));
//        hocPhanRepository.save(new HocPhan("Hệ cơ sở dữ liệu", null,new Khoa(1),3,1));
//        hocPhanRepository.save(new HocPhan("Mạng máy tính", null,new Khoa(1),3,0));
//        hocPhanRepository.save(new HocPhan("Hệ quản trị cơ sở dữ liệu", null, new Khoa(1),2,1));
//        hocPhanRepository.save(new HocPhan("Lập trình hướng sự kiện với công nghệ Java", null, new Khoa(1),3,1));
//        hocPhanRepository.save(new HocPhan("Lập trình WWW (Java)", new Nganh(3), null,3,1));
//        hocPhanRepository.save(new HocPhan("Công nghệ mới trong phát triển ứng dụng CNTT", new Nganh(3), null,2,1));
//        hocPhanRepository.save(new HocPhan("Giao tiếp kinh doanh", null,null,3,0));
//        hocPhanRepository.save(new HocPhan("Kỹ năng xây dựng kế hoạch", null,null,3,0));
        return khoaCNTT.toString();
    }

    @GetMapping("/getDataSample1")
    public String getDataSample2() {
        return khoaNganhService.getKhoaById(1).toString();
    }

    @GetMapping("/createDataSample2")
    public String setHocPhanTienQuyet(){
        hocPhanService.setHocPhanTienQuyet(1,3);
        System.out.println(hocPhanService.getHocPhanById(1).getHocPhanTienQuyet().toString());
        hocKyNienGiamRepository.save(new HocKyNienGiam(3,16,1));
        hocKyNienGiamRepository.save(new HocKyNienGiam(3,16,2));
        return hocPhanService.getHocKyNienGiamByNganhAndKhoa(3,16).toString();
    }
}
