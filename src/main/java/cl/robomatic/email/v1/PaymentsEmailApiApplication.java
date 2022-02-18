package cl.robomatic.email.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@Slf4j
@EnableJms
@SpringBootApplication
public class PaymentsEmailApiApplication {

	public static void main(String[] args) {
		String ciCommitSha = System.getenv("CI_COMMIT_SHA");
		String springProfilesActive = System.getenv("SPRING_PROFILES_ACTIVE");

		log.info("CI_COMMIT_SHA: {}", ciCommitSha);
		log.info("SPRING_PROFILES_ACTIVE: {}", springProfilesActive);

		SpringApplication.run(PaymentsEmailApiApplication.class, args);
	}

}
