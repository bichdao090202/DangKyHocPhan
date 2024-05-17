package vn.edu.iuh.fit.lichhocservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lichhocservice.model.GiangVien;
import vn.edu.iuh.fit.lichhocservice.model.LichHoc;

import java.util.List;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, Long> {
    List<LichHoc> findAllByGiangVien(GiangVien gv);
}