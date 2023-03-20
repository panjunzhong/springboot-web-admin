package nb.djpan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "nb.djpan.admin")
@SpringBootApplication
public class SpringbootWebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebAdminApplication.class, args);
	}

}
