package vn.edu.iuh.fit.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SinhVienRequest {
    private long maSinhVien;
    private long maNganh;
    private int khoa;
}
