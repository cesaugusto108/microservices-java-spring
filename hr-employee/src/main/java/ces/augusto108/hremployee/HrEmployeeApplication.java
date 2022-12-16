package ces.augusto108.hremployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrEmployeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrEmployeeApplication.class, args);
	}
}
