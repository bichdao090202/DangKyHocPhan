package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
}