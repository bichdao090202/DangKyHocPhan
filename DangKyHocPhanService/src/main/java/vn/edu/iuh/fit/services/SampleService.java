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
public class SampleService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private GiangVienRepository giangVienRepository;

    public SinhVien createSinhVien(SinhVienRequest sinhVien) {
        return sinhVienRepository.save(new SinhVien(sinhVien));
    }

    public GiangVien createGiangVien(GiangVienRequest giangVien) {
        return giangVienRepository.save(new GiangVien(giangVien));
    }

}
