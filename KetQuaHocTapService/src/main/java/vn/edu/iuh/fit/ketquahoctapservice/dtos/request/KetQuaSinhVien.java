package vn.edu.iuh.fit.ketquahoctapservice.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class KetQuaSinhVien {
    private long maSinhVien;
    private List<Double> listDiem;




}
