package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.SinhVien_LichHoc;
import vn.edu.iuh.fit.pks.SinhVien_LichHocPK;

@Repository
public interface SinhVien_LichHocRepository extends JpaRepository<SinhVien_LichHoc, SinhVien_LichHocPK> {
}