package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.LichHoc;
import vn.edu.iuh.fit.models.SinhVien_LichHoc;
import vn.edu.iuh.fit.pks.SinhVien_LichHocPK;

import java.util.List;

@Repository
public interface SinhVien_LichHocRepository extends JpaRepository<SinhVien_LichHoc, SinhVien_LichHocPK> {

    @Query(value = "SELECT sv_lh FROM SinhVien_LichHoc sv_lh WHERE sv_lh.maLichHoc.maLichHoc IN\n" +
            "( SELECT lh.maLichHoc FROM LichHoc lh WHERE lh.lopHocPhan.maLopHocPhan IN\n" +
            "( SELECT lhp.maLopHocPhan FROM LopHocPhan lhp WHERE lhp.hocPhan.maHocPhan = :maHP )) AND sv_lh.maSV.maSV = :maSV")
    List<SinhVien_LichHoc> getLichHocByMaHP(@Param("maHP") long maHP, @Param("maSV")long maSV);
}