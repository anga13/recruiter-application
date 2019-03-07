package se.kth.iv1201.grupp13.recruiterapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RecruiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruiterApplication.class, args);
	}

}

