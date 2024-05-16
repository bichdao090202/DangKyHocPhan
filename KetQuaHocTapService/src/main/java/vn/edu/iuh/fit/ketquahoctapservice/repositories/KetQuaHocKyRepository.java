package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.ketquahoctapservice.ids.KetQuaHocKyId;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;

import java.util.List;

public interface KetQuaHocKyRepository extends JpaRepository<KetQuaHocKy, KetQuaHocKyId> {
    @Query("SELECT k FROM KetQuaHocKy k WHERE k.id.maSinhVien = ?1 AND k.id.hocKy = ?2")
    KetQuaHocKy findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);

    @Query("SELECT k FROM KetQuaHocKy k WHERE k.id.maSinhVien = ?1")
    List<KetQuaHocKy> findByMaSinhVien(long maSinhVien);
}
