package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dtos.request.LopHocPhanRequest;
import vn.edu.iuh.fit.dtos.request.PhongHocRequest;
import vn.edu.iuh.fit.dtos.response.LopHocPhanResponse;
import vn.edu.iuh.fit.models.HocPhan;
import vn.edu.iuh.fit.models.LopHocPhan;
import vn.edu.iuh.fit.models.PhongHoc;
import vn.edu.iuh.fit.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class LopHocPhanService {
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

    @Autowired
    private HocPhanDaDangKyRepository hocPhanDaDangKyRepository;

    @Autowired
    private HocPhanService hocPhanService;

    @Autowired
    private PhongHocRepository phongHocRepository;
    @Autowired
    private GiangVienRepository giangVienRepository;

    public PhongHoc createPhongHoc(PhongHocRequest phongHocRequest) {
        PhongHoc phongHoc = new PhongHoc(phongHocRequest.getTenPhong(), phongHocRequest.isPhongLyThuyet());
        return phongHocRepository.save(phongHoc);
    }

    public LopHocPhan createLopHocPhan(LopHocPhanRequest lopHocPhanRequest) {
        return lopHocPhanRepository.save(new LopHocPhan(lopHocPhanRequest));
    }

    public List<LopHocPhanResponse> getLopHocPhanByHocPhan(HocPhan hocPhan) {
        List<LopHocPhanResponse> lopHocPhanResponses = new ArrayList<>();
        List<LopHocPhan> lopHocPhans = lopHocPhanRepository.findByHocPhan(hocPhan);
        if (lopHocPhans == null)
            return null;    // không tìm thấy
        for (LopHocPhan lopHocPhan : lopHocPhans) {
            LopHocPhanResponse lopHocPhanResponse = new LopHocPhanResponse(lopHocPhan);
            lopHocPhanResponses.add(lopHocPhanResponse);
        }
        return lopHocPhanResponses;
    }
}
