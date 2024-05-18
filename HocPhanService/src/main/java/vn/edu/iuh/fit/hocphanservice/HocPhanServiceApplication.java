package vn.edu.iuh.fit.hocphanservice;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
//@OpenAPIDefinition(servers = {@Server(url = "/HocPhanService", description = "Default Server URL")})
public class HocPhanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HocPhanServiceApplication.class, args);
	}

}
