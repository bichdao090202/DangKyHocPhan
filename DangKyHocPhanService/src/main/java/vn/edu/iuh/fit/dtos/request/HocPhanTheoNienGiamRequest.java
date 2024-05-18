package vn.edu.iuh.fit.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HocPhanTheoNienGiamRequest {
    private long maHocPhan;
    private long maHocKyNienGiam;

    // body example:
    // {
    //     "maHocPhan": 1,
    //     "maHocKyNienGiam": 1
    // }


}
