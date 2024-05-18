package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.HocPhan;
import vn.edu.iuh.fit.models.Nganh;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
    boolean existsByNganh(Nganh nganh);
}