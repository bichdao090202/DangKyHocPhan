package vn.edu.iuh.fit.ketquahoctapservice.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.ketquahoctapservice.dtos.request.KetQuaSinhVien;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class KetQuaHocPhan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maKetQuaHocPhan;
    private double thuongKy1;
    private double thuongKy2;
    private double thuongKy3;
    private double giuaKy;
    private double thucHanh1;
    private double thucHanh2;
    private double thucHanh3;
    private double cuoiKy;
    private double ketQuaHeSo;
    private String ketQuaChu;
    private String xepLoai;
    private boolean quaMon;
    @ManyToOne @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;
    private long maSinhVien;

    public KetQuaHocPhan(KetQuaSinhVien ketQuaSinhVien) {
        this.maSinhVien = ketQuaSinhVien.getMaSinhVien();
        this.thuongKy1 = ketQuaSinhVien.getListDiem().get(0);
        this.thuongKy2 = ketQuaSinhVien.getListDiem().get(1);
        this.thuongKy3 = ketQuaSinhVien.getListDiem().get(2);
        this.giuaKy = ketQuaSinhVien.getListDiem().get(3);
        if (ketQuaSinhVien.getListDiem().size()>5){
            this.thucHanh1 = ketQuaSinhVien.getListDiem().get(4);
            this.thucHanh2 = ketQuaSinhVien.getListDiem().get(5);
            this.thucHanh3 = ketQuaSinhVien.getListDiem().get(6);
            this.cuoiKy = ketQuaSinhVien.getListDiem().get(7);
            tinhDiemMonThucHanh();
        } else {
            this.cuoiKy = ketQuaSinhVien.getListDiem().get(4);
            tinhDiemMonLyThuyet();
        }
        xepLoai();
        this.quaMon = this.ketQuaHeSo >= 3 && this.cuoiKy >= 4;
    }

    private void tinhDiemMonLyThuyet(){
        this.ketQuaHeSo = ((this.thuongKy1 + this.thuongKy2 + this.thuongKy3)/3*2 + this.giuaKy*3 + this.cuoiKy*5) / 10;
    }

    private void tinhDiemMonThucHanh(){
        this.ketQuaHeSo = ((this.thuongKy1 + this.thuongKy2 + this.thuongKy3)/3*2 + this.giuaKy*3 + this.cuoiKy*5
                +(thucHanh1+thucHanh2+thucHanh3)/3*5) / 15;
    }

    private void xepLoai(){
        if (this.ketQuaHeSo >= 9) {
            this.xepLoai = "Xuất sắc";
            this.ketQuaChu = "A+";
        } else if (this.ketQuaHeSo >= 8) {
            this.xepLoai = "Giỏi";
            this.ketQuaChu = "A";
        } else if (this.ketQuaHeSo >= 7) {
            this.xepLoai = "Khá";
            this.ketQuaChu = "B";
        } else if (this.ketQuaHeSo >= 5.5) {
            this.xepLoai = "Trung bình";
            this.ketQuaChu = "C";
        } else if (this.ketQuaHeSo >= 4) {
            this.xepLoai = "Yếu";
            this.ketQuaChu = "D";
        } else {
            this.xepLoai = "Kém";
            this.ketQuaChu = "F";
        }
    }

    public boolean checkDiemHopLe(){
        if (this.thuongKy1 < 1 || this.thuongKy1 > 10) return false;
        if (this.thuongKy2 < 1 || this.thuongKy2 > 10) return false;
        if (this.thuongKy3 < 1 || this.thuongKy3 > 10) return false;
        if (this.giuaKy < 1 || this.giuaKy > 10) return false;
//        if (this.thucHanh1 < 1 || this.thucHanh1 > 10) return false;
//        if (this.thucHanh2 < 1 || this.thucHanh2 > 10) return false;
//        if (this.thucHanh3 < 1 || this.thucHanh3 > 10) return false;
        if (this.cuoiKy < 1 || this.cuoiKy > 10) return false;
        return true;
    }


}
