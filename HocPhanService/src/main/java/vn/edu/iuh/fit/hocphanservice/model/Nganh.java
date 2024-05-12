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

    @Override
    public String toString() {
        return "Nganh{" +
                "maNganh=" + maNganh +
                ", tenNganh='" + tenNganh + '\'' +
                '}';
    }

}
