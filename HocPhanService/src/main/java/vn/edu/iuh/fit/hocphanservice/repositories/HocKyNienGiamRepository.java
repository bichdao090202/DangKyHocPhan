package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.hocphanservice.model.HocKyNienGiam;
import vn.edu.iuh.fit.hocphanservice.model.Nganh;

import java.util.List;

public interface HocKyNienGiamRepository extends JpaRepository<HocKyNienGiam, Long> {
    @Query ("SELECT h FROM HocKyNienGiam h WHERE h.nganh = ?1 AND h.khoa = ?2")
    List<HocKyNienGiam> findByNganhAndKhoa(Nganh nganh, long khoa);

    @Query ("SELECT h FROM HocKyNienGiam h WHERE h.nganh = ?1 AND h.khoa = ?2 AND h.hocKy = ?3")
    List<HocKyNienGiam> findByNganhAndKhoaAndHocKy(Nganh nganh, long khoa, int hocKy);

    boolean existsByNganhAndKhoaAndHocKy(Nganh nganh, long khoa, int hocKy);

}
