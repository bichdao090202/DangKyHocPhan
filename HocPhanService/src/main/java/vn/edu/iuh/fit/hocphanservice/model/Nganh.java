package vn.edu.iuh.fit.hocphanservice.model;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Nganh {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long maNganh;
    private String tenNganh;
    @ManyToOne @JoinColumn(name = "maKhoa")
    private Khoa khoa;

    public Nganh(long maNganh) {
        this.maNganh = maNganh;
    }

    public Nganh(String tenNganh, Khoa khoa) {
        this.tenNganh = tenNganh;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "Nganh{" +
                "maNganh=" + maNganh +
                ", tenNganh='" + tenNganh + '\'' +
                '}';
    }

}
