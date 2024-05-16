package vn.edu.iuh.fit.ketquahoctapservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.DiemLopHocPhanRequest;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
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
    public KetQuaHocPhan nhapDiemChoSinhVien(KetQuaSinhVien ketQuaSinhVien, long maHocPhan, int hocKy) {
        if (ketQuaSinhVien.getListDiem().size() != 5 && ketQuaSinhVien.getListDiem().size() != 8)
            return null;    // số lượng điểm không hợp lệ
        HocPhan hocPhan = hocPhanRepository.findById(maHocPhan).orElse(null);
        if (hocPhan == null)
            return null;    // mã học phần không tồn tại
        if (hocPhan.getSoTinChiThucHanh()>0&&ketQuaSinhVien.getListDiem().size() == 5)
            return null;    // số lượng điểm không hợp lệ
        KetQuaHocPhan ketQuaHocPhan = new KetQuaHocPhan(ketQuaSinhVien,hocPhan);
        if (!ketQuaHocPhan.checkDiemHopLe())
            return null;    // điểm không hợp lệ
        ketQuaHocPhan.setHocPhan(new HocPhan(maHocPhan));
        ketQuaHocPhan.setHocKy(hocKy);
        KetQuaHocPhan tmp = ketQuaHocPhanRepository.findByHocPhanAndMaSinhVien(new HocPhan(maHocPhan), ketQuaSinhVien.getMaSinhVien());
        if (tmp != null)
            ketQuaHocPhan.setMaKetQuaHocPhan(tmp.getMaKetQuaHocPhan());     // update kết quả cũ
        ketQuaHocPhan.setHocPhan(hocPhan);
        createKetQuaHocKy(ketQuaSinhVien.getMaSinhVien(), hocKy, ketQuaHocPhan);
        return ketQuaHocPhanRepository.save(ketQuaHocPhan);
    }
    public List<Long> nhapDiemChoLopHocPhan(DiemLopHocPhanRequest diemLopHocPhanRequest) {
        HocPhan hocPhan = hocPhanRepository.findById(diemLopHocPhanRequest.getMaHocPhan()).orElse(null);
        if (hocPhan == null)
            return null;    // mã học phần không tồn tại
        List<Long> danhSachMSSVDiemKhongHopLe = new ArrayList<>();
        for (KetQuaSinhVien ketQuaSinhVien : diemLopHocPhanRequest.getListKetQuaSinhVien()) {
            if (ketQuaSinhVien.getListDiem().size() != 5 && ketQuaSinhVien.getListDiem().size() != 8) {
                danhSachMSSVDiemKhongHopLe.add(ketQuaSinhVien.getMaSinhVien());
                continue;
            }
            if (hocPhan.getSoTinChiThucHanh()>0&&ketQuaSinhVien.getListDiem().size() == 5)
                return null;    // số lượng điểm không hợp lệ
            KetQuaHocPhan ketQuaHocPhan = new KetQuaHocPhan(ketQuaSinhVien,hocPhan);
            if (!ketQuaHocPhan.checkDiemHopLe()){
                danhSachMSSVDiemKhongHopLe.add(ketQuaSinhVien.getMaSinhVien());
                continue;
            }
            ketQuaHocPhan.setHocPhan(new HocPhan(diemLopHocPhanRequest.getMaHocPhan()));
            ketQuaHocPhan.setHocKy(diemLopHocPhanRequest.getHocKy());
            KetQuaHocPhan tmp = ketQuaHocPhanRepository.findByHocPhanAndMaSinhVien(new HocPhan(diemLopHocPhanRequest.getMaHocPhan()), ketQuaSinhVien.getMaSinhVien());
            if (tmp != null)
                ketQuaHocPhan.setMaKetQuaHocPhan(tmp.getMaKetQuaHocPhan());     // update kết quả cũ
            ketQuaHocPhan.setHocPhan(hocPhan);
            createKetQuaHocKy(ketQuaSinhVien.getMaSinhVien(), diemLopHocPhanRequest.getHocKy(), ketQuaHocPhan);
            ketQuaHocPhanRepository.save(ketQuaHocPhan);
        }
        return danhSachMSSVDiemKhongHopLe;
    }

    private void createKetQuaHocKy(long maSinhVien, int hocKy, KetQuaHocPhan ketQuaHocPhan){
        KetQuaHocKy ketQuaHocKy = ketQuaHocKyRepository.findByMaSinhVienAndHocKy(maSinhVien, hocKy);
        if (ketQuaHocKy == null){
            ketQuaHocKy = new KetQuaHocKy(maSinhVien, ketQuaHocPhan, hocKy);
            ketQuaHocKyRepository.save(ketQuaHocKy);
        } else {
            List<KetQuaHocPhan> ketQuaHocPhanList = ketQuaHocPhanRepository.findByMaSinhVienAndHocKy(maSinhVien, hocKy);
            if (!ketQuaHocPhanList.contains(ketQuaHocPhan))
                ketQuaHocPhanList.add(ketQuaHocPhan);
            ketQuaHocKy.updateKeQuaHocKy(ketQuaHocPhanList);
            ketQuaHocKyRepository.save(ketQuaHocKy);
        }
    }

    public List<KetQuaHocKy> getKetQuaSinhVien(long maSinhVien) {
        System.out.println(ketQuaHocKyRepository.findByMaSinhVien(maSinhVien));
        return ketQuaHocKyRepository.findByMaSinhVien(maSinhVien);
    }
}
