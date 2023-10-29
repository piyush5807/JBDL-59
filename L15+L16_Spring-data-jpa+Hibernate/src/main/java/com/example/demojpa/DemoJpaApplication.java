package com.example.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}


	// 1. ddl-auto modes -- done
	// 2. debugging save function end to end (hibernate related things I will show)
	// 3. auto increment using identity generation type and some discussion on hibernate sequence as well
	// 4. custom queries and some annotations like transactional, modifying etc.

}
