package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.hocphanservice.model.HocKyNienGiam;
import vn.edu.iuh.fit.hocphanservice.model.HocPhan;
import vn.edu.iuh.fit.hocphanservice.model.HocPhanTheoNienGiam;
import vn.edu.iuh.fit.hocphanservice.model.Nganh;

import java.util.List;

public interface HocPhanTheoNienGiamRepository extends JpaRepository<HocPhanTheoNienGiam, Long> {
    List<HocPhanTheoNienGiam> findByHocKyNienGiam(HocKyNienGiam hocKyNienGiam);

    boolean existsByHocPhan(HocPhan hocPhan);
}
