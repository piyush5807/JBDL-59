package com.example.demosecuritydb;

import com.example.demosecuritydb.models.DemoUser;
import com.example.demosecuritydb.repository.DemoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityDbApplication implements CommandLineRunner {

	@Autowired
	DemoUserRepository demoUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityDbApplication.class, args);
		System.out.println("Hello world!!!!");
	}


	@Override
	public void run(String... args) throws Exception {
		DemoUser demoUser = DemoUser.builder()
				.username("nikita")
				.password(new BCryptPasswordEncoder().encode("nikita123"))
				.authorities("login_faculty::access_library")
				.build();

//		DemoUser demoUser3 = DemoUser.builder()
//				.username("nikita")
//				.password(new BCryptPasswordEncoder().encode("nikita1234"))
//				.authorities("login_student::access_library")
//				.build();

		DemoUser demoUser2 = DemoUser.builder()
				.username("kapil")
				.password(new BCryptPasswordEncoder().encode("kapil123"))
				.authorities("login_student::access_library")
				.build();

		demoUserRepository.saveAll(Arrays.asList(demoUser, demoUser2));
	}
}
