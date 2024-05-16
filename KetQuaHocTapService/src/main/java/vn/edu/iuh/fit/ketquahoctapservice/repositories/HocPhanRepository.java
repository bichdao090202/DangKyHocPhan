package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;

import java.util.List;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
//    SELECT * FROM hoc_phan WHERE hoc_phan.ma_hoc_phan IN (SELECT ket_qua_hoc_phan.ma_hoc_phan FROM ket_qua_hoc_phan WHERE ma_sinh_vien=1 AND hoc_ky=1)
    @Query("SELECT hp FROM HocPhan hp WHERE hp.maHocPhan IN (SELECT kqhp.hocPhan.maHocPhan FROM KetQuaHocPhan kqhp WHERE kqhp.maSinhVien=?1 AND kqhp.hocKy=?2)")
    List<HocPhan> findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);
}
