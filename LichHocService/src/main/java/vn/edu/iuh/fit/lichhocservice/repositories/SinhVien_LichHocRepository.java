package vn.edu.iuh.fit.lichhocservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lichhocservice.model.SinhVien;
import vn.edu.iuh.fit.lichhocservice.model.SinhVien_LichHoc;
import vn.edu.iuh.fit.lichhocservice.pks.SinhVien_LichHocPK;

import java.util.List;

@Repository
public interface SinhVien_LichHocRepository extends JpaRepository<SinhVien_LichHoc, SinhVien_LichHocPK> {
    List<SinhVien_LichHoc> findAllByMaSV(SinhVien maSV);
}