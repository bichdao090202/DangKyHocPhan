package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.pks.SinhVien_LichHocPK;
import vn.edu.iuh.fit.repositories.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DangKyHocPhanService")
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

    @PostMapping("/dkhp")
    public boolean dangKyHocPhan(@RequestParam("maSV")String maSV, @RequestParam("maLichHoc")String maLichHoc){
        try{
            Optional<SinhVien> sv = sinhVienRepository.findById(Long.parseLong(maSV));
            Optional<LichHoc> lh = lichHocRepository.findById(Long.parseLong(maLichHoc));
            if(sv.isPresent() && lh.isPresent()){
                SinhVien sinhVien = sv.get();
                LichHoc lichHoc = lh.get();
                Optional<SinhVien_LichHoc> sl = sinhVienLichHocRepository.findById(new SinhVien_LichHocPK(Long.parseLong(maSV), Long.parseLong(maLichHoc)));
                if(sl.isEmpty()){
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
                    sinhVienRepository.save(sinhVien);
                    lichHocRepository.save(lichHoc);
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
}
