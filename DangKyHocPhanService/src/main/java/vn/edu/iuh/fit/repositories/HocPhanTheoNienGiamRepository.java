package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.HocKyNienGiam;
import vn.edu.iuh.fit.models.HocPhan;
import vn.edu.iuh.fit.models.HocPhanTheoNienGiam;

import java.util.List;

public interface HocPhanTheoNienGiamRepository extends JpaRepository<HocPhanTheoNienGiam, Long> {
    List<HocPhanTheoNienGiam> findByHocKyNienGiam(HocKyNienGiam hocKyNienGiam);
    boolean existsByHocPhan(HocPhan hocPhan);

    boolean existsByHocPhanAndHocKyNienGiam(HocPhan hocPhan, HocKyNienGiam hocKyNienGiam);

    List<HocPhanTheoNienGiam> findByHocKyNienGiamIn(List<HocKyNienGiam> hocKyNienGiamList);
}
