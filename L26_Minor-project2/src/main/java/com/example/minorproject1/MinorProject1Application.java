package com.example.minorproject1;

import com.example.minorproject1.dto.CreateAdminRequest;
import com.example.minorproject1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinorProject1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MinorProject1Application.class, args);
	}

	@Autowired
	AdminService adminService;

	@Override
	public void run(String... args) throws Exception {

//		adminService.create(
//				CreateAdminRequest.builder()
//						.name("Yusaf")
//						.username("yusaf@gmail.com")
//						.password("yusaf123")
//						.build()
//		);
	}
}
