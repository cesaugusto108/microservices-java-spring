package ces.augusto108.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	/*
	This is just for test and demonstration of BCrypt.
	One of the generated hashes is used in data.sql as a mock password.
	*/
	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCrypt: " + passwordEncoder.encode("p@ZZw0Rd"));
	}
}
