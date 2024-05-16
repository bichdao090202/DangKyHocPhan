package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;

import java.util.List;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
    @Query("SELECT h FROM HocPhan h WHERE h.maHocPhan IN (SELECT k.hocPhan.maHocPhan FROM KetQuaHocPhan k WHERE k.ketQuaHocKy.id.maSinhVien = ?1 AND k.ketQuaHocKy.id.hocKy = ?2)")
    List<HocPhan> findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);
}
