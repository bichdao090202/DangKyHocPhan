package vn.edu.iuh.fit.ketquahoctapservice.repositories;

import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocKy;
import vn.edu.iuh.fit.ketquahoctapservice.model.KetQuaHocPhan;

import java.util.List;

public interface KetQuaHocPhanRepository extends JpaRepository<KetQuaHocPhan, Long> {

    boolean existsByHocPhanAndMaSinhVien(HocPhan hocPhan, long maSinhVien);
    KetQuaHocPhan findByHocPhanAndMaSinhVien(HocPhan hocPhan, long maSinhVien);

    List<KetQuaHocPhan> findByMaSinhVienAndHocKy(long maSinhVien, int hocKy);

}
