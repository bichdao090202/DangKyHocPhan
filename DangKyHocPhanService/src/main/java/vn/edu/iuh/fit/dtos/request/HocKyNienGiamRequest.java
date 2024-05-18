package vn.edu.iuh.fit.dtos.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class HocKyNienGiamRequest {
    private long maNganh;
    private int khoa;
    private int hocKy;
    private List<Long> hocPhanTheoNienGiam; 

}
