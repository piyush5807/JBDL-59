package com.example.majorproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MajorProjectApplication {

	/**
	 * userId is only used inside user-service since it's a primary of their db, they only should handle it
	 * Every other service be it txn service, or wallet service or notification service should communicate on username i.e mobile
	 * No inter service communication should happen on userId;
	 */

	/**
	 * 1. User onboarding --> user-service (permit all) --> wallet service --> (extension) notification service sending email that the wallet has been created
	 * 2. User transaction --> txn-service (secured) --> user-service (for authentication) --> wallet-service --> publishes an event after updating wallet
	 * 3. Wallet update event consumed by txn service --> updates txn status --> publishes txn complete event --> notification service --> send email
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(MajorProjectApplication.class, args);
	}

}
