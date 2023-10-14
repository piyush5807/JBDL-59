package com.example.demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication {

	// SpringbootApplication --> SpringbootConfiguration --> Configuration --> Component

	private static Logger logger = LoggerFactory.getLogger("abc");

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
		logger.error("Error log");
		logger.warn("Warn log");
		logger.info("Info log"); // ---here ---
		logger.debug("Debug log");
		logger.trace("Trace log");
	}

	/**
	 * Trace - 1707
	 * Debug - 710
	 * Info - 92
	 * Warn - 1 (which we have put)
	 *
	 */


	/**
	 * ERROR - will be most severe and minimum in number (whenever there is any error)
	 * WARN - whenever there is some kind of error which is less severe, code is going to an unexpected block, edge cases which are not handled
	 * INFO - Logs which help you in debugging your application logic
	 * DEBUG - Logs which help you in debugging your application logic + spring boot's internal working
	 * TRACE - will be least severe and maximum in number (whenever you want to print even the tiniest of the things for ex: a heartbeat of an embedded server)
	 */

}
