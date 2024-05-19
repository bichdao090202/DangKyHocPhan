package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.HocPhan;
import vn.edu.iuh.fit.models.LopHocPhan;

import java.util.List;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
    List<LopHocPhan> findAllByHocPhan(HocPhan hp);

    List<LopHocPhan> findByHocPhan(HocPhan hocPhan);
}