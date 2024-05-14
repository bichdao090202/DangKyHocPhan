package vn.edu.iuh.fit.hocphanservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.hocphanservice.model.Khoa;
import vn.edu.iuh.fit.hocphanservice.model.Nganh;
import vn.edu.iuh.fit.hocphanservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.hocphanservice.repositories.KhoaRepository;
import vn.edu.iuh.fit.hocphanservice.repositories.NganhRepository;

import java.util.List;


@Service
public class KhoaNganhService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;

    public Khoa createKhoa(String tenKhoa) {
        boolean isExist = khoaRepository.existsByTenKhoa(tenKhoa);
        if (isExist) {
            return null;
        }
        return khoaRepository.save(new Khoa(tenKhoa));
    }

    public Nganh createNganh(String tenNganh, long maKhoa) {
        boolean isExist = nganhRepository.existsByTenNganh(tenNganh);
        if (isExist) {
            return null;
        }
        Khoa khoa = khoaRepository.findById(maKhoa).orElse(null);
        if (khoa == null) {
            return null;
        }
        return nganhRepository.save(new Nganh(tenNganh, khoa));
    }

    public Khoa updateTenKhoa(long maKhoa, String tenKhoa) {
        Khoa khoa = khoaRepository.findById(maKhoa).orElse(null);
        if (khoa == null) {
            return null;
        }
        khoa.setTenKhoa(tenKhoa);
        return khoaRepository.save(khoa);
    }

    public Nganh updateTenNganh(long maNganh, String tenNganh) {
        Nganh nganh = nganhRepository.findById(maNganh).orElse(null);
        if (nganh == null) {
            return null;
        }
        nganh.setTenNganh(tenNganh);
        return nganhRepository.save(nganh);
    }

    public Khoa getKhoaById(long id) {
        return khoaRepository.findById(id).orElse(null);
    }

    public Nganh getNganhById(long id) {
        return nganhRepository.findById(id).orElse(null);
    }

    public boolean deleteKhoa(long id) {
        boolean checkNganh = nganhRepository.existsByKhoa(new Khoa(id));
        if (checkNganh) {
            return false;
        }
        if (!khoaRepository.existsById(id)) {
            khoaRepository.deleteById(id);
        }
        return true;
    }

    public boolean deleteNganh(long id) {
        boolean checkHocPhan = hocPhanRepository.existsByNganh(new Nganh(id));
        if (checkHocPhan) {
            return false;
        }
        if (!nganhRepository.existsById(id)) {
            nganhRepository.deleteById(id);
        }
        return true;
    }

    public List<Nganh> getNganhByKhoa(long id) {
        Khoa khoa = khoaRepository.findById(id).orElse(null);
        if (khoa == null) {
            return null;
        }
        return khoa.getNganhs();
    }


}
