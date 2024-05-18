package vn.edu.iuh.fit.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.pks.SinhVien_HocPhanPK;
import vn.edu.iuh.fit.pks.SinhVien_LichHocPK;
import vn.edu.iuh.fit.repositories.*;
import vn.edu.iuh.fit.services.HocPhanService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DangKyHocPhanService")
@CrossOrigin("*")

public class DangKyHocPhanController {
    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    @Autowired
    private LichHocRepository lichHocRepository;

    @Autowired
    private SinhVien_LichHocRepository sinhVienLichHocRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private HocPhanDaDangKyRepository hocPhanDaDangKyRepository;

    @Autowired
    private HocPhanService hocPhanService;

    @GetMapping("/sinhVien")
    public SinhVien getSinhVienByMaSV(@RequestParam("maSV")String maSV) {
        try {
            Optional<SinhVien> sv = sinhVienRepository.findById(Long.parseLong(maSV));
            return sv.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/lopHocPhan")
    public List<LopHocPhan> getLopHocPhanByMaHP(@RequestParam("maHP")String maHP){
        try{
            Optional<HocPhan> hp = hocPhanRepository.findById(Long.parseLong(maHP));
            return hp.map(hocPhan -> lopHocPhanRepository.findAllByHocPhan(hocPhan)).orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/hocPhanDaDangKy")
    public List<HocPhanDaDangKy> getDanhSachHocPhanDaDangKy(@RequestParam("maSV")String maSV){
        try {
            Optional<SinhVien> sv = sinhVienRepository.findById(Long.parseLong(maSV));
            if (sv.isPresent()) {
                return hocPhanDaDangKyRepository.findAllByMaSV(sv.get());
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @PostMapping("/dkhp")
    @Transactional
    public String dangKyHocPhan(@RequestParam("maSV")String maSV, @RequestParam("maLichHoc")String maLichHoc, @RequestParam("hocKy")String hocKy) throws RuntimeException{
        try{
            Optional<SinhVien> sv = sinhVienRepository.findById(Long.parseLong(maSV));
            Optional<LichHoc> lh = lichHocRepository.findById(Long.parseLong(maLichHoc));
            if(sv.isPresent() && lh.isPresent()){
                SinhVien sinhVien = sv.get();
                LichHoc lichHoc = lh.get();
                HocPhan hocPhan = hocPhanRepository.getHocPhanByLichHoc(Long.parseLong(maLichHoc));

                List<HocPhanTienQuyet> hptq = hocPhanService.getHocPhanTienQuyet(hocPhan.getMaHocPhan());
                for(HocPhanTienQuyet h : hptq){
                    Optional<HocPhanDaDangKy> hpdktq = hocPhanDaDangKyRepository.findById(new SinhVien_HocPhanPK(sinhVien.getMaSV(), h.getMaHocPhan()));
                    if(hpdktq.isEmpty() || hpdktq.get().getHocKyDangKy() == Float.parseFloat(hocKy)){
                        return "Học phần có môn học phần tiên quyết chưa được đăng ký hoặc đang đăng kí trong học kỳ này!";
                    }
                }

                Optional<SinhVien_LichHoc> sl = sinhVienLichHocRepository.findById(new SinhVien_LichHocPK(Long.parseLong(maSV), Long.parseLong(maLichHoc)));
                Optional<HocPhanDaDangKy> sh = hocPhanDaDangKyRepository.findById(new SinhVien_HocPhanPK(Long.parseLong(maSV), hocPhan.getMaHocPhan()));
                if(sl.isEmpty() && sh.isEmpty()){
                    List<SinhVien_LichHoc> l = sinhVien.getSinhVienLichHocList();
                    SinhVien_LichHoc svlh = new SinhVien_LichHoc();
                    svlh.setMaSV(sinhVien);
                    svlh.setMaLichHoc(lichHoc);
                    l.add(svlh);
                    sinhVien.setSinhVienLichHocList(l);
                    List<SinhVien_LichHoc> l2 = lichHoc.getSinhVienLichHocList();
                    l2.add(svlh);
                    lichHoc.setSinhVienLichHocList(l2);
                    sinhVienLichHocRepository.save(svlh);
                    lichHocRepository.save(lichHoc);

                    List<HocPhanDaDangKy> hpdkSV = sinhVien.getHocPhanDaDangKyList();
                    HocPhanDaDangKy hpdk = new HocPhanDaDangKy(sinhVien, hocPhan, Float.parseFloat(hocKy), LocalDate.now());
                    hpdkSV.add(hpdk);
                    sinhVien.setHocPhanDaDangKyList(hpdkSV);
                    List<HocPhanDaDangKy> hpdkHP = hocPhan.getHocPhanDaDangKyList();
                    hpdkHP.add(hpdk);
                    hocPhan.setHocPhanDaDangKyList(hpdkHP);
                    hocPhanDaDangKyRepository.save(hpdk);
                    sinhVienRepository.save(sinhVien);
                    hocPhanRepository.save(hocPhan);
                    return "OK";
                }
            }
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException();
        }
        return "Đã xảy ra lỗi trong quá trình đăng ký!";
    }

    @DeleteMapping("/huyDKHP")
    @Transactional
    public boolean huyDangKyHocPhan(@RequestParam("maSV")String maSV, @RequestParam("maHocPhan")String maHocPhan) throws RuntimeException{
        try{
            Optional<SinhVien> sv = sinhVienRepository.findById(Long.parseLong(maSV));
            Optional<HocPhan> hp = hocPhanRepository.findById(Long.parseLong(maHocPhan));
            if(sv.isPresent() && hp.isPresent()){
                Optional<HocPhanDaDangKy> hocPhanDaDangKy = hocPhanDaDangKyRepository.findById(new SinhVien_HocPhanPK(sv.get().getMaSV(), hp.get().getMaHocPhan()));
                if(hocPhanDaDangKy.isEmpty()) return false;
                SinhVien sinhVien = sv.get();
                HocPhan hocPhan = hp.get();
                List<HocPhanDaDangKy> listHPSV = sinhVien.getHocPhanDaDangKyList();
                listHPSV.remove(hocPhanDaDangKy.get());
                sinhVien.setHocPhanDaDangKyList(listHPSV);

                List<HocPhanDaDangKy> listHPHP = hocPhan.getHocPhanDaDangKyList();
                listHPHP.remove(hocPhanDaDangKy.get());
                hocPhan.setHocPhanDaDangKyList(listHPHP);
                hocPhanDaDangKyRepository.delete(hocPhanDaDangKy.get());
                hocPhanRepository.save(hocPhan);

                SinhVien_LichHoc lh = sinhVienLichHocRepository.getLichHocByMaHP(hocPhan.getMaHocPhan(), sinhVien.getMaSV()).get(0);
                List<SinhVien_LichHoc> svlhSV = sinhVien.getSinhVienLichHocList();
                svlhSV.remove(lh);
                sinhVien.setSinhVienLichHocList(svlhSV);

                LichHoc lichHoc = lichHocRepository.findById(lh.getMaLichHoc().getMaLichHoc()).get();

                List<SinhVien_LichHoc> svlhLH = lichHoc.getSinhVienLichHocList();
                svlhLH.remove(lh);
                lichHoc.setSinhVienLichHocList(svlhLH);

                sinhVienLichHocRepository.delete(lh);
                sinhVienRepository.save(sinhVien);
                lichHocRepository.save(lichHoc);

                return true;
            }
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException();
        }
        return false;
    }
}
