package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.hocphanservice.model.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, Long> {
    boolean existsByTenKhoa(String tenKhoa);
}
