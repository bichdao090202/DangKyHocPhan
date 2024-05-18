package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, Long> {
    Khoa findByTenKhoa(String tenKhoa);
}
