package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;

import java.util.List;

public interface KetQuaHocPhanRepository extends JpaRepository<KetQuaHocPhan, Long> {
    @Query("SELECT k FROM KetQuaHocPhan k WHERE k.hocPhan = ?1 AND k.ketQuaHocKy.id.maSinhVien = ?2")
    KetQuaHocPhan findByHocPhanAndMaSinhVien(HocPhan hocPhan, long maSinhVien);

    List<KetQuaHocPhan> findByKetQuaHocKy(KetQuaHocKy ketQuaHocKy);

}
