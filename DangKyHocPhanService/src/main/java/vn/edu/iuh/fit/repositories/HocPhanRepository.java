package vn.edu.iuh.fit.repositories;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.HocPhan;
import vn.edu.iuh.fit.models.Nganh;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
    boolean existsByNganh(Nganh nganh);

    @Query("SELECT hp FROM HocPhan  hp WHERE hp.maHocPhan IN\n" +
            "( SELECT lhp.hocPhan.maHocPhan FROM LopHocPhan lhp WHERE lhp.maLopHocPhan IN \n" +
            "\t(SELECT lh.lopHocPhan.maLopHocPhan FROM LichHoc lh WHERE lh.maLichHoc = :maLichHoc)\n" +
            ")")
    HocPhan getHocPhanByLichHoc(@Param("maLichHoc") long maLichHoc);
}