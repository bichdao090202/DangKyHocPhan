package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.hocphanservice.model.HocPhanTienQuyet;

import java.util.List;

public interface HocPhanTienQuyetRepository extends JpaRepository<HocPhanTienQuyet, Long>, CrudRepository<HocPhanTienQuyet, Long>{
    @Query("SELECT h FROM HocPhanTienQuyet h WHERE h.maHocPhan = ?1 AND h.maHocPhanTienQuyet = ?2")
    public List<HocPhanTienQuyet> findByMaHocPhanAndMaHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet);
}
