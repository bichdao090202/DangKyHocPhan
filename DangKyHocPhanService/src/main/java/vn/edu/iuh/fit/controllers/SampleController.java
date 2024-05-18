package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.dtos.request.HocKyNienGiamRequest;
import vn.edu.iuh.fit.dtos.request.HocPhanRequest;
import vn.edu.iuh.fit.dtos.res.HocPhanTheoNienGiamResponse;
import vn.edu.iuh.fit.models.HocKyNienGiam;
import vn.edu.iuh.fit.models.Khoa;
import vn.edu.iuh.fit.repositories.HocKyNienGiamRepository;
import vn.edu.iuh.fit.repositories.HocPhanRepository;
import vn.edu.iuh.fit.services.HocPhanService;
import vn.edu.iuh.fit.services.KhoaNganhService;

import java.util.List;


@RestController
@RequestMapping("SampleController")
public class SampleController {
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private KhoaNganhService khoaNganhService;

    @GetMapping("/createDataSample1")
    public Khoa createDataSample() {
        Khoa khoaCNTT = khoaNganhService.createKhoa("Cong nghe thong tin");
        Khoa khoaKT = khoaNganhService.createKhoa("Kinh te");
        khoaNganhService.createNganh("Cong nghe thong tin", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("He thong thong tin", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Ky thuat phan mem", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Kinh te doi ngoai", khoaKT.getMaKhoa());
        khoaNganhService.createNganh("Xuat nhap khau", khoaKT.getMaKhoa());
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
        return khoaCNTT;
    }
    @GetMapping ("/createDataSample2")
    public String createDataSample2(){
        HocPhanRequest hocPhanRequest = new HocPhanRequest("Lap trinh huong doi tuong",0,1,2,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Cau truc du lieu giai thuat ",0,1,3,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("He co so du lieu",0,1,3,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Mang may tinh",0,1,3,0);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("He quan tri co so du lieu",0,1,2,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Lap trinh huong su kien voi cong nghe Java",0,1,3,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Lap trinh WWW (Java)",3,0,3,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Cong nghe moi trong phat trien ung dung CNTT",3,0,2,1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Giao tiep kinh doanh",0,0,3,0);
        hocPhanService.createHocPhan(hocPhanRequest);
        return "Success";
    }

    @GetMapping("/createDataSample3")
    public boolean themHocPhanVaoNienGiam(){
        hocPhanService.setHocPhanTienQuyet(1,3);
        HocKyNienGiamRequest hocKyNienGiamRequest = new HocKyNienGiamRequest(3,16,1, List.of(1L,2L,3L));
        hocPhanService.createHocKyNienGiam(hocKyNienGiamRequest);
        HocKyNienGiamRequest hocKyNienGiamRequest1 = new HocKyNienGiamRequest(3,16,2, List.of(4L,5L,6L));
        hocPhanService.createHocKyNienGiam(hocKyNienGiamRequest1);
        return true;
    }

    @GetMapping ("/createDataSample4")
    List<HocPhanTheoNienGiamResponse> getNienGiamByNganhAndKhoa(){
        return hocPhanService.getNienGiamByNganhAndKhoa(3,16);
    }
}
