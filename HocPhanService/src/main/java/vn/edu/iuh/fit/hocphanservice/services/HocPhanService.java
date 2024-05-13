package vn.edu.iuh.fit.hocphanservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.hocphanservice.model.*;
import vn.edu.iuh.fit.hocphanservice.repositories.*;

import java.util.List;

@Service
public class HocPhanService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;
    @Autowired
    private HocPhanTienQuyetRepository hocPhanTienQuyetRepository;
    @Autowired
    private HocKyNienGiamRepository hocKyNienGiamRepository;
    @Autowired
    private HocPhanTheoNienGiamRepository hocPhanTheoNienGiamRepository;
    @Autowired
    private NhomHocPhanTuChonRepository nhomHocPhanTuChonRepository;



//  Khoa - Nganh
    public Khoa createKhoa(Khoa khoa) {
        boolean isExist = khoaRepository.existsByTenKhoa(khoa.getTenKhoa());
        if (isExist) {
            return null;
        }
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

    public Khoa getKhoaById(long id) {
        return khoaRepository.findById(id).orElse(null);
    }


//    HocPhan
    public HocPhan createHocPhan(HocPhan hocPhan) {
        return hocPhanRepository.save(hocPhan);
    }

    public HocPhan getHocPhanById(long id) {
        return hocPhanRepository.findById(id).orElse(null);
    }

    public HocPhanTienQuyet createHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet) {
        HocPhanTienQuyet hptq = new HocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        List<HocPhanTienQuyet> tmp = hocPhanTienQuyetRepository.findByMaHocPhanAndMaHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (tmp.size() > 0) {
            return null;
        }
        return hocPhanTienQuyetRepository.save(hptq);
    }

    public String createHocKyNienGiam(HocKyNienGiam hocKyNienGiam){
        if (hocKyNienGiamRepository.existsByNganhAndKhoaAndHocKy(hocKyNienGiam.getNganh(),hocKyNienGiam.getKhoa(),hocKyNienGiam.getHocKy())){
            return "false";
        }
        hocKyNienGiamRepository.save(hocKyNienGiam);
        return "true";
    }

    public List<HocKyNienGiam> getHocKyNienGiamByNganhAndKhoa(long maNganh, long khoa){
        return hocKyNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh),khoa);
    }

    public List<HocKyNienGiam> getHocKyNienGiamByNganhAndKhoaAndHocKy(long maNganh, long khoa, int hocKy){
        return hocKyNienGiamRepository.findByNganhAndKhoaAndHocKy(new Nganh(maNganh),khoa,hocKy);
    }

    public HocPhanTheoNienGiam themHocPhanVaoNienGiam(HocPhanTheoNienGiam hocPhanTheoNienGiam){
        return hocPhanTheoNienGiamRepository.save(hocPhanTheoNienGiam);
    }


    public List<HocPhanTheoNienGiam> findHocPhanTheoNienGiamByNganhAndKhoa(long maNganh, int khoa){
        List<HocKyNienGiam> hocKyNienGiam = hocKyNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh),khoa);
        System.out.println(hocKyNienGiam);
        return null;
//        return hocPhanTheoNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh),khoa);
    }
}
