package vn.edu.iuh.fit.hocphanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.hocphanservice.model.HocPhanTienQuyet;

import java.util.List;

public interface HocPhanTienQuyetRepository extends JpaRepository<HocPhanTienQuyet, Long>, CrudRepository<HocPhanTienQuyet, Long>{
    public List<HocPhanTienQuyet> findByMaHocPhan(long maHocPhan);

    public boolean existsByMaHocPhanAndMaHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet);

    @Query("SELECT h FROM HocPhanTienQuyet h WHERE h.maHocPhan = ?1 AND h.maHocPhanTienQuyet = ?2")
    public HocPhanTienQuyet findByMaHocPhanAndMaHocPhanTienQuyet(long maHocPhan, long maHocPhanTienQuyet);

    boolean existsByMaHocPhan(long id);
}
