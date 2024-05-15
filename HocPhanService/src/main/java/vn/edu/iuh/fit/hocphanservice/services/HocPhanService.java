package vn.edu.iuh.fit.hocphanservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocKyNienGiamRequest;
import vn.edu.iuh.fit.hocphanservice.dtos.request.HocPhanRequest;
import vn.edu.iuh.fit.hocphanservice.model.*;
import vn.edu.iuh.fit.hocphanservice.repositories.*;

import java.util.ArrayList;
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

    public HocPhan createHocPhan(HocPhanRequest hocPhanRequest) {
        if ((hocPhanRequest.getMaKhoa() != 0 && !khoaRepository.existsById(hocPhanRequest.getMaKhoa()))
                || (hocPhanRequest.getMaNganh() != 0 && !nganhRepository.existsById(hocPhanRequest.getMaNganh()))) {
            return null;    // mã ngành hoặc mã khoa không tồn tại
        }
        HocPhan hocPhan = new HocPhan(hocPhanRequest.getTen(),
                hocPhanRequest.getMaNganh() == 0 ? null : new Nganh(hocPhanRequest.getMaNganh()),
                hocPhanRequest.getMaKhoa() == 0 ? null : new Khoa(hocPhanRequest.getMaKhoa()),
                hocPhanRequest.getSoTinChiLyThuyet(),
                hocPhanRequest.getSoTinChiThucHanh());
        return hocPhanRepository.save(hocPhan);
    }

    public HocPhan getHocPhanById(long id) {
        return hocPhanRepository.findById(id).orElse(null);
    }

    public boolean deleteHocPhan(long id) {
        if (!hocPhanRepository.existsById(id))
            return false;       // không tìm thấy id
        if (hocPhanTheoNienGiamRepository.existsByHocPhan(new HocPhan(id)))
            return false;       // học phần đã được sử dụng trong học kỳ niên giảm
        if (hocPhanTienQuyetRepository.existsByMaHocPhan(id))
            return false;       // học phần đã được sử dụng trong học phần tiên quyết
        hocPhanRepository.deleteById(id);
        return true;
    }

    public HocPhanTienQuyet setHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet) {
        if (!existsHocPhan(maHocPhan) || !existsHocPhan(maHocPhanTienQuyet))
            return null;       // không tìm thấy mã học phần hoặc mã học phần tiên quyết
        HocPhanTienQuyet hptq = new HocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        boolean res = hocPhanTienQuyetRepository.existsByMaHocPhanAndMaHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (res)
            return null;    // đã tồn tại quan hệ
        return hocPhanTienQuyetRepository.save(hptq);
    }

    public List<HocPhanTienQuyet> getHocPhanTienQuyet(long id) {
        if (!existsHocPhan(id))
            return null;    // không tìm thấy mã học phần
        return hocPhanTienQuyetRepository.findByMaHocPhan(id);
    }

    public boolean deleteHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet) {
        if (!existsHocPhan(maHocPhan) || !existsHocPhan(maHocPhanTienQuyet))
            return false;       // không tìm thấy mã học phần hoặc mã học phần tiên quyết
        HocPhanTienQuyet hptq = hocPhanTienQuyetRepository.findByMaHocPhanAndMaHocPhanTienQuyet(maHocPhan, maHocPhanTienQuyet);
        if (hptq != null)
            hocPhanTienQuyetRepository.delete(hptq);
        return true;
    }

    public HocKyNienGiam createHocKyNienGiam(HocKyNienGiamRequest hocKyNienGiamRequest) {
        HocKyNienGiam hocKyNienGiam = new HocKyNienGiam(hocKyNienGiamRequest.getMaNganh(), hocKyNienGiamRequest.getKhoa(), hocKyNienGiamRequest.getHocKy());
        if (hocKyNienGiamRepository.existsByNganhAndKhoaAndHocKy(hocKyNienGiam.getNganh(), hocKyNienGiam.getKhoa(), hocKyNienGiam.getHocKy()))
            return null;    // đã tồn tại học kỳ niên giảm
        if (hocKyNienGiam.getHocPhanTheoNienGiam().isEmpty())
            return hocKyNienGiamRepository.save(hocKyNienGiam); // chỉ tạo học kỳ
        List<HocPhanTheoNienGiam> hocPhanTheoNienGiamList = new ArrayList<>();
        for (Long t : hocKyNienGiamRequest.getHocPhanTheoNienGiam()) {
            HocPhanTheoNienGiam hocPhanTheoNienGiam = new HocPhanTheoNienGiam(new HocPhan(t), hocKyNienGiam);
            hocPhanTheoNienGiamRepository.save(hocPhanTheoNienGiam);        //thêm học phần vào học kỳ niên giảm
            hocPhanTheoNienGiamList.add(hocPhanTheoNienGiam);
        }
        hocKyNienGiam.setHocPhanTheoNienGiam(hocPhanTheoNienGiamList);
        hocKyNienGiamRepository.save(hocKyNienGiam);
        return hocKyNienGiam;
    }

    public HocPhanTheoNienGiam themHocPhanVaoNienGiam(HocPhanTheoNienGiam hocPhanTheoNienGiam) {
        return hocPhanTheoNienGiamRepository.save(hocPhanTheoNienGiam);
    }

    public List<HocKyNienGiam> getHocKyNienGiamByNganhAndKhoa(long maNganh, long khoa) {
        return hocKyNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh), khoa);
    }

    public List<HocKyNienGiam> getHocKyNienGiamByNganhAndKhoaAndHocKy(long maNganh, long khoa, int hocKy) {
        return hocKyNienGiamRepository.findByNganhAndKhoaAndHocKy(new Nganh(maNganh), khoa, hocKy);
    }


    public List<HocPhanTheoNienGiam> findHocPhanTheoNienGiamByNganhAndKhoa(long maNganh, int khoa) {
        List<HocKyNienGiam> hocKyNienGiam = hocKyNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh), khoa);
        System.out.println(hocKyNienGiam);
        return null;
//        return hocPhanTheoNienGiamRepository.findByNganhAndKhoa(new Nganh(maNganh),khoa);
    }

    public boolean existsHocPhan(long id) {
        return hocPhanRepository.existsById(id);
    }
}
