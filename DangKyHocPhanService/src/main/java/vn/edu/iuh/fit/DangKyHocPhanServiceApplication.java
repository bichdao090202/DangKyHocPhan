package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class DangKyHocPhanServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DangKyHocPhanServiceApplication.class, args);
    }

}
