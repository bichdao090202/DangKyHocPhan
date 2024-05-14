package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.hocphanservice.model.HocPhan;
import vn.edu.iuh.fit.hocphanservice.model.Nganh;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
    boolean existsByNganh(Nganh nganh);
}
