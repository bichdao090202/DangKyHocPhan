package vn.edu.iuh.fit.ketquahoctapservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.DiemLopHocPhanRequest;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.KetQuaHocKyRepository;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.KetQuaHocPhanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class KetQuaHocTapService {
    @Autowired
    private KetQuaHocPhanRepository ketQuaHocPhanRepository;
    @Autowired
    private KetQuaHocKyRepository ketQuaHocKyRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;

    //*check học phần thực hành
    public KetQuaHocPhan nhapDiemChoSinhVien(KetQuaSinhVien ketQuaSinhVien, long maHocPhan) {
        if (ketQuaSinhVien.getListDiem().size() != 5 && ketQuaSinhVien.getListDiem().size() != 8)
            return null;    // số lượng điểm không hợp lệ
        if (!hocPhanRepository.existsById(maHocPhan))
            return null;    // mã học phần không tồn tại
        KetQuaHocPhan ketQuaHocPhan = new KetQuaHocPhan(ketQuaSinhVien);
        if (!ketQuaHocPhan.checkDiemHopLe())
            return null;    // điểm không hợp lệ
        ketQuaHocPhan.setHocPhan(new HocPhan(maHocPhan));
        KetQuaHocPhan tmp = ketQuaHocPhanRepository.findByHocPhanAndMaSinhVien(new HocPhan(maHocPhan), ketQuaSinhVien.getMaSinhVien());
        if (tmp != null)
            ketQuaHocPhan.setMaKetQuaHocPhan(tmp.getMaKetQuaHocPhan());     // update kết quả cũ
        return ketQuaHocPhanRepository.save(ketQuaHocPhan);
    }

    public List<Long> nhapDiemChoLopHocPhan(DiemLopHocPhanRequest diemLopHocPhanRequest) {
        if (!hocPhanRepository.existsById(diemLopHocPhanRequest.getMaHocPhan()))
            return null;    // mã học phần không tồn tại
        List<Long> danhSachMSSVDiemKhongHopLe = new ArrayList<>();
        for (KetQuaSinhVien ketQuaSinhVien : diemLopHocPhanRequest.getListKetQuaSinhVien()) {
            if (ketQuaSinhVien.getListDiem().size() != 5 && ketQuaSinhVien.getListDiem().size() != 8) {
                danhSachMSSVDiemKhongHopLe.add(ketQuaSinhVien.getMaSinhVien());
                continue;
            }
            KetQuaHocPhan ketQuaHocPhan = new KetQuaHocPhan(ketQuaSinhVien);
            if (!ketQuaHocPhan.checkDiemHopLe()){
                danhSachMSSVDiemKhongHopLe.add(ketQuaSinhVien.getMaSinhVien());
                continue;
            }
            ketQuaHocPhan.setHocPhan(new HocPhan(diemLopHocPhanRequest.getMaHocPhan()));
            KetQuaHocPhan tmp = ketQuaHocPhanRepository.findByHocPhanAndMaSinhVien(new HocPhan(diemLopHocPhanRequest.getMaHocPhan()), ketQuaSinhVien.getMaSinhVien());
            if (tmp != null)
                ketQuaHocPhan.setMaKetQuaHocPhan(tmp.getMaKetQuaHocPhan());     // update kết quả cũ
            ketQuaHocPhanRepository.save(ketQuaHocPhan);
        }
        return danhSachMSSVDiemKhongHopLe;
    }
}
