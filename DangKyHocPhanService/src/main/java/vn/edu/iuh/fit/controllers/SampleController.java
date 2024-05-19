package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dtos.request.*;


import vn.edu.iuh.fit.dtos.response.HocPhanResponse;
import vn.edu.iuh.fit.dtos.response.LopHocPhanResponse;
import vn.edu.iuh.fit.models.HocPhan;
import vn.edu.iuh.fit.models.Khoa;
import vn.edu.iuh.fit.services.HocPhanService;
import vn.edu.iuh.fit.services.KhoaNganhService;
import vn.edu.iuh.fit.services.LopHocPhanService;
import vn.edu.iuh.fit.services.UserService;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("SampleController")
@CrossOrigin("*")
public class SampleController {
    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private KhoaNganhService khoaNganhService;
    @Autowired
    private LopHocPhanService lopHocPhanService;
    @Autowired
    private UserService userService;

    @GetMapping("/createDataSample1")
    public Khoa createDataSample() {
        Khoa khoaCNTT = khoaNganhService.createKhoa("Cong nghe thong tin");
        Khoa khoaKT = khoaNganhService.createKhoa("Kinh te");
        khoaNganhService.createNganh("Ky thuat phan mem", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("Cong nghe thong tin", khoaCNTT.getMaKhoa());
        khoaNganhService.createNganh("He thong thong tin", khoaCNTT.getMaKhoa());
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

    @GetMapping("/createDataSample2")
    public String createDataSample2() {
        HocPhanRequest hocPhanRequest = new HocPhanRequest("Lap trinh huong doi tuong", 0, 1, 2, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Cau truc du lieu giai thuat ", 0, 1, 3, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("He co so du lieu", 0, 1, 3, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Mang may tinh", 0, 1, 3, 0);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("He quan tri co so du lieu", 0, 1, 2, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Lap trinh huong su kien voi cong nghe Java", 0, 1, 3, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Lap trinh WWW (Java)", 1, 0, 3, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Cong nghe moi trong phat trien ung dung CNTT", 1, 0, 2, 1);
        hocPhanService.createHocPhan(hocPhanRequest);
        hocPhanRequest = new HocPhanRequest("Giao tiep kinh doanh", 0, 0, 3, 0);
        hocPhanService.createHocPhan(hocPhanRequest);
        return "Success";
    }

    @GetMapping("/createDataSample3")
    public boolean themHocPhanVaoNienGiam() {
        hocPhanService.setHocPhanTienQuyet(1, 3);
        HocKyNienGiamRequest hocKyNienGiamRequest = new HocKyNienGiamRequest(1, 16, 1, List.of(1L, 2L, 3L));
        hocPhanService.createHocKyNienGiam(hocKyNienGiamRequest);
        HocKyNienGiamRequest hocKyNienGiamRequest1 = new HocKyNienGiamRequest(1, 16, 2, List.of(4L, 5L, 6L));
        hocPhanService.createHocKyNienGiam(hocKyNienGiamRequest1);
        userService.createSinhVien(new SinhVienRequest(10001, 1,16));
        userService.createSinhVien(new SinhVienRequest(10002, 2,17));
        userService.createGiangVien(new GiangVienRequest(5001, "Giang vien 1", 1));
        userService.createGiangVien(new GiangVienRequest(5002, "Giang vien 2", 2));
        userService.createGiangVien(new GiangVienRequest(5003, "Giang vien 3", 1));
        return true;
    }

    @GetMapping("/createDataSample4")
    public String taoPhongHoc() {
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.1", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.2", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.3", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.4", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.5", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.6", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.7", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.8", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.9", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("X10.10", true));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H3.1", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H3.2", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H3.3", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H4.1", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H4.2", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H8.1", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H8.2", false));
        lopHocPhanService.createPhongHoc(new PhongHocRequest("H8.3", false));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(1,5001, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(2,5001, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(3,5001, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(4,5001, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(2,5002, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(2,5002, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(2,5002, LocalDate.now()));
        lopHocPhanService.createLopHocPhan(new LopHocPhanRequest(1,5003, LocalDate.now()));
        return "Success";
    }

    @GetMapping("/createDataSample5/{maNganh}/{khoa}")
    List<HocPhanResponse> findDanhSachHocPhanSinhVienCoTheDangKy(@PathVariable long maNganh, @PathVariable int khoa) {
        return hocPhanService.findDanhSachHocPhanSinhVienCoTheDangKy(maNganh, khoa);
    }
    @GetMapping (
            "/createDataSample6/{maHocPhan}")
    public List<LopHocPhanResponse> getLopHocPhanByMaSinhVien(@PathVariable long maHocPhan){
        return lopHocPhanService.getLopHocPhanByHocPhan(new HocPhan(maHocPhan));
    }
}
