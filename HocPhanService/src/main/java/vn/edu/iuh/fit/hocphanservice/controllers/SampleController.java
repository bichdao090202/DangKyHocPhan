package vn.edu.iuh.fit.hocphanservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.hocphanservice.model.*;
import vn.edu.iuh.fit.hocphanservice.services.HocPhanService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {
    @Autowired
    private HocPhanService hocPhanService;

    @GetMapping("/createDataSample1")
    public String createDataSample() {
        Khoa khoaCNTT = new Khoa("Công nghệ thông tin");
        Khoa res = hocPhanService.createKhoa(khoaCNTT);
        if (res == null) {
            return "false";
        }
        hocPhanService.createNganh(new Nganh("Công nghệ thông tin", khoaCNTT));
        hocPhanService.createNganh(new Nganh("Hệ thống thông tin", khoaCNTT));
        hocPhanService.createNganh(new Nganh("Kỹ thuật phần mềm", khoaCNTT));
        hocPhanService.createNganh(new Nganh("Khoa học dữ liệu", khoaCNTT));
        hocPhanService.createNganh(new Nganh("An toàn thông tin", khoaCNTT));
        hocPhanService.createNganh(new Nganh("Khoa học máy tính", khoaCNTT));
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
        return hocPhanService.getKhoaById(1).toString();
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
    public String createDataSample5() {
        HocPhanTheoNienGiam hocPhanTheoNienGiam = new HocPhanTheoNienGiam(1,1);
        return hocPhanService.themHocPhanVaoNienGiam(hocPhanTheoNienGiam).toString();
    }

}
