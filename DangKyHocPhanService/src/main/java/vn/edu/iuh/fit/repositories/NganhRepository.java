package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Khoa;
import vn.edu.iuh.fit.models.Nganh;

public interface NganhRepository extends JpaRepository<Nganh, Long> {
    boolean existsByTenNganh(String tenNganh);

    boolean existsByKhoa(Khoa khoa);
}
