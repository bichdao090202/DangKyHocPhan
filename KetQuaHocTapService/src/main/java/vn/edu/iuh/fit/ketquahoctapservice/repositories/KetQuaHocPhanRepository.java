package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;

public interface KetQuaHocPhanRepository extends JpaRepository<KetQuaHocPhan, Long> {

    boolean existsByHocPhanAndMaSinhVien(HocPhan hocPhan, long maSinhVien);
    KetQuaHocPhan findByHocPhanAndMaSinhVien(HocPhan hocPhan, long maSinhVien);
}
