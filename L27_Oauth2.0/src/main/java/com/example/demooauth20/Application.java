package com.example.demooauth20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * As soon as you include apring-boot-starter-oauth2-client dependency in your pom.xml,
	 * it has an API in it's codebase which has the path /oauth2/authorization/:registrationId
	 */

}
