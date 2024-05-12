package vn.edu.iuh.fit.hocphanservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.hocphanservice.model.Khoa;
import vn.edu.iuh.fit.hocphanservice.model.Nganh;
import vn.edu.iuh.fit.hocphanservice.repositories.*;

@Service
public class HocPhanService {
//    @Autowired
//    private HocPhanRepository hocPhanRepository;
//    @Autowired
//    private HocPhanTheoNienGiamRepository hocPhanTheoNienGiamRepository;
    @Autowired
    private NganhRepository nganhRepository;
//    @Autowired
//    private NhomHocPhanTuChonRepository nhomHocPhanTuChonRepository;
    @Autowired
    private KhoaRepository khoaRepository;

    public Khoa createKhoa(Khoa khoa) {
        return khoaRepository.save(khoa);
    }

    public Nganh createNganh(Nganh nganh) {
        return nganhRepository.save(nganh);
    }

    public Khoa updateKhoa(Khoa khoa) {
        return khoaRepository.save(khoa);
    }

    public Nganh updateNganh(Nganh nganh) {
        return nganhRepository.save(nganh);
    }


}
