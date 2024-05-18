package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.HocPhanDaDangKy;
import vn.edu.iuh.fit.models.SinhVien;
import vn.edu.iuh.fit.pks.SinhVien_HocPhanPK;

import java.util.List;

public interface HocPhanDaDangKyRepository extends JpaRepository<HocPhanDaDangKy, SinhVien_HocPhanPK> {
    List<HocPhanDaDangKy> findAllByMaSV(SinhVien sv);
}