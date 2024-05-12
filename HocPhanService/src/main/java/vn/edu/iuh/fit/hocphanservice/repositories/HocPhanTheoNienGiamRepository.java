package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.hocphanservice.model.HocPhan;
import vn.edu.iuh.fit.hocphanservice.model.HocPhanTheoNienGiam;

public interface HocPhanTheoNienGiamRepository extends JpaRepository<HocPhanTheoNienGiam, Long> {
}
