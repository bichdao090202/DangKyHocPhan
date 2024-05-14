package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.hocphanservice.model.*;
import vn.edu.iuh.fit.hocphanservice.services.HocPhanService;
import vn.edu.iuh.fit.hocphanservice.services.KhoaNganhService;

@RestController
public class SampleController {
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private KhoaNganhService khoaNganhService;

    @GetMapping("/createDataSample1")
    public String createDataSample() {
        Khoa khoaCNTT = khoaNganhService.createKhoa("Công nghệ thông tin");
        if (khoaCNTT == null) {
            return "false";
        }
        khoaNganhService.createNganh("Công nghệ thông tin", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Hệ thống thông tin", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Kỹ thuật phần mềm", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Khoa học dữ liệu", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("An toàn thông tin", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Khoa học máy tính", khoaCNTT.getMaKhoa());
        hocPhanService.createHocPhan(new HocPhan("Lập trình hướng đối tượng", null,new Khoa(1),2,1));
        hocPhanService.createHocPhan(new HocPhan("Cấu trúc dữ liệu và giải thuật", null,new Khoa(1),3,1));
        hocPhanService.createHocPhan(new HocPhan("Hệ cơ sở dữ liệu", null,new Khoa(1),3,1));
        hocPhanService.createHocPhan(new HocPhan("Mạng máy tính", null,new Khoa(1),3,0));
        hocPhanService.createHocPhan(new HocPhan("Hệ quản trị cơ sở dữ liệu", null, new Khoa(1),2,1));
        hocPhanService.createHocPhan(new HocPhan("Lập trình hướng sự kiện với công nghệ Java", null, new Khoa(1),3,1));
        hocPhanService.createHocPhan(new HocPhan("Lập trình WWW (Java)", new Nganh(3), null,3,1));
        hocPhanService.createHocPhan(new HocPhan("Công nghệ mới trong phát triển ứng dụng CNTT", new Nganh(3), null,2,1));
        hocPhanService.createHocPhan(new HocPhan("Giao tiếp kinh doanh", null,null,3,0));
        hocPhanService.createHocPhan(new HocPhan("Kỹ năng xây dựng kế hoạch", null,null,3,0));
        return khoaCNTT.toString();
    }

    @GetMapping("/getDataSample1")
    public String getDataSample2() {
        return khoaNganhService.getKhoaById(1).toString();
    }

    @GetMapping("/createDataSample2")
    public String setHocPhanTienQuyet(){
        hocPhanService.createHocPhanTienQuyet(1,3);
        System.out.println(hocPhanService.getHocPhanById(1).getHocPhanTienQuyet().toString());
        hocPhanService.createHocKyNienGiam(new HocKyNienGiam(3,16,1));
        hocPhanService.createHocKyNienGiam(new HocKyNienGiam(3,16,2));
        return hocPhanService.getHocKyNienGiamByNganhAndKhoa(3,16).toString();
    }


    @GetMapping("/createDataSample3")
    public String createDataSample3() {
        HocPhanTheoNienGiam hocPhanTheoNienGiam = new HocPhanTheoNienGiam(1,1);
        return hocPhanService.themHocPhanVaoNienGiam(hocPhanTheoNienGiam).toString();
    }

}
