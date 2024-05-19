package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.LichHoc;
import vn.edu.iuh.fit.models.LopHocPhan;
import vn.edu.iuh.fit.repositories.LichHocRepository;
import vn.edu.iuh.fit.repositories.LopHocPhanRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DangKyHocPhan")
@CrossOrigin("*")
public class LichHocController {
    @Autowired
    private LichHocRepository lichHocRepository;

    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    @GetMapping("/lichHoc")
    public List<LichHoc> getLichHocByMaLHP(@RequestParam("maLHP")String maLHP){
        try{
            Optional<LopHocPhan> lhp = lopHocPhanRepository.findById(Long.parseLong(maLHP));
            if(lhp.isPresent()){
                return lichHocRepository.findAllByLopHocPhan(lhp.get());
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

}
