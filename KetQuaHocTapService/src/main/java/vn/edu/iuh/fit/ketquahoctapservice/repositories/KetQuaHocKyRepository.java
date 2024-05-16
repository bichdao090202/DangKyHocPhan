package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;

import java.util.List;

public interface KetQuaHocKyRepository extends JpaRepository<KetQuaHocKy, Long> {
    KetQuaHocKy findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);


    List<KetQuaHocKy> findByMaSinhVien(long maSinhVien);
}
