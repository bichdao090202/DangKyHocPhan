package vn.edu.iuh.fit.dtos.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class HocKyNienGiamRequest {
    private long maNganh;
    private int khoa;
    private int hocKy;
    private List<Long> hocPhanTheoNienGiam; 

    // body example:
    // {
    //     "maNganh": 3,
    //     "khoa": 16,
    //     "hocKy": 1,
    //     "hocPhanTheoNienGiam": [1, 2, 3]
    // }
}
