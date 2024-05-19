package vn.edu.iuh.fit.lichhocservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.lichhocservice.model.GiangVien;
import vn.edu.iuh.fit.lichhocservice.model.LichHoc;
import vn.edu.iuh.fit.lichhocservice.model.SinhVien;
import vn.edu.iuh.fit.lichhocservice.model.SinhVien_LichHoc;
import vn.edu.iuh.fit.lichhocservice.repositories.GiangVienRepository;
import vn.edu.iuh.fit.lichhocservice.repositories.LichHocRepository;
import vn.edu.iuh.fit.lichhocservice.repositories.SinhVienRepository;
import vn.edu.iuh.fit.lichhocservice.repositories.SinhVien_LichHocRepository;
import vn.edu.iuh.fit.lichhocservice.services.LichHocService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/LichHoc")
@CrossOrigin("*")
public class LichHocController {
    @Autowired
    private LichHocRepository lichHocRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private SinhVien_LichHocRepository sinhVienLichHocRepository;

    @Autowired
    private LichHocService lichHocService;

    @GetMapping("/")
    public List<LichHoc> lichhoc() {
        return lichHocRepository.findAll();
    }

    @GetMapping("/giangVien")
    public List<LichHoc> getLichHocByGiangVien(@RequestParam("maGV") String maGV) {
        try {
            Optional<GiangVien> gv = giangVienRepository.findById(Long.parseLong(maGV));
            if (gv.isPresent())
                return lichHocRepository.findAllByGiangVien(gv.get());
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/sinhVien")
    public List<LichHoc> getLichHocBySinhVien(@RequestParam("maSV") String maSV) {
        try {
            Optional<SinhVien> sv = sinhVienRepository.findById(Long.parseLong(maSV));
            if (sv.isPresent()) {
                List<SinhVien_LichHoc> svlh = sinhVienLichHocRepository.findAllByMaSV(sv.get());
                List<LichHoc> lh = new ArrayList<>();
                for (SinhVien_LichHoc s : svlh)
                    lh.add(lichHocRepository.findById(s.getMaLichHoc().getMaLichHoc()).get());
                return lh;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @GetMapping("/lichHocTuan/sinhVien")
    public List<LichHoc> getLichHocTuanSinhVien(@RequestParam("maSV") String maSV,
                                                @RequestParam("date") String date){
        try{
            String[] arrDate = date.split("-");
            LocalDate d = LocalDate.of(Integer.parseInt(arrDate[2]), Integer.parseInt(arrDate[1]), Integer.parseInt(arrDate[0]));
            List<LichHoc> lh = getLichHocBySinhVien(maSV);
            if(lh == null) return null;
            List<LichHoc> result = new ArrayList<>();
            for (LichHoc l: lh) {
                LocalDate start = lichHocService.getDateStartOfWeek(d);
                if(l.getNgayHoc() == start || l.getNgayHoc() == start.plusDays(6))
                    result.add(l);
                else{
                    if(l.getNgayHoc().isAfter(start) && l.getNgayHoc().isBefore(start.plusDays(6)))
                        result.add(l);
                }
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }

}
