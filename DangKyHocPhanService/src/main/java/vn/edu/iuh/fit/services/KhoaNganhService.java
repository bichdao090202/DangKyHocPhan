package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Khoa;
import vn.edu.iuh.fit.models.Nganh;
import vn.edu.iuh.fit.repositories.HocPhanRepository;
import vn.edu.iuh.fit.repositories.KhoaRepository;
import vn.edu.iuh.fit.repositories.NganhRepository;

import java.util.List;


@Service
public class KhoaNganhService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;

    public Khoa getKhoaById(long id) {
        return khoaRepository.findById(id).orElse(null);
    }

    public Nganh getNganhById(long id) {
        return nganhRepository.findById(id).orElse(null);
    }

    public Khoa createKhoa(String tenKhoa) {
        Khoa khoa = khoaRepository.findByTenKhoa(tenKhoa);
        if (khoa!=null)
            return khoa;
        return khoaRepository.save(new Khoa(tenKhoa));
    }

    public Nganh createNganh(String tenNganh, long maKhoa) {
        Nganh nganh = nganhRepository.findByTenNganh(tenNganh);
        if (nganh!=null)
            return nganh;
        Khoa khoa = khoaRepository.findById(maKhoa).orElse(null);
        if (khoa == null)
            return null;
        return nganhRepository.save(new Nganh(tenNganh, khoa));
    }

    public Khoa updateTenKhoa(long maKhoa, String tenKhoa) {
        Khoa khoa = khoaRepository.findById(maKhoa).orElse(null);
        if (khoa == null)
            return null;
        khoa.setTenKhoa(tenKhoa);
        return khoaRepository.save(khoa);
    }

    public Nganh updateTenNganh(long maNganh, String tenNganh) {
        Nganh nganh = nganhRepository.findById(maNganh).orElse(null);
        if (nganh == null)
            return null;
        nganh.setTenNganh(tenNganh);
        return nganhRepository.save(nganh);
    }

    public boolean deleteKhoa(long id) {
        boolean checkNganh = nganhRepository.existsByKhoa(new Khoa(id));
        if (checkNganh)
            return false;
        if (!khoaRepository.existsById(id))
            khoaRepository.deleteById(id);
        return true;
    }

    public boolean deleteNganh(long id) {
        boolean checkHocPhan = hocPhanRepository.existsByNganh(new Nganh(id));
        if (checkHocPhan)
            return false;
        if (!nganhRepository.existsById(id))
            nganhRepository.deleteById(id);
        return true;
    }

    public List<Nganh> getNganhByKhoa(long id) {
        Khoa khoa = khoaRepository.findById(id).orElse(null);
        if (khoa == null)
            return null;
        return khoa.getNganhList();
    }

}
