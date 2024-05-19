package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dtos.request.GiangVienRequest;
import vn.edu.iuh.fit.dtos.request.SinhVienRequest;
import vn.edu.iuh.fit.models.GiangVien;
import vn.edu.iuh.fit.models.SinhVien;
import vn.edu.iuh.fit.repositories.GiangVienRepository;
import vn.edu.iuh.fit.repositories.SinhVienRepository;

@Service
public class UserService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private GiangVienRepository giangVienRepository;

    public void createSinhVien(SinhVienRequest sinhVien) {
        sinhVienRepository.save(new SinhVien(sinhVien));
    }

    public void createGiangVien(GiangVienRequest giangVien) {
        giangVienRepository.save(new GiangVien(giangVien));
    }

}
