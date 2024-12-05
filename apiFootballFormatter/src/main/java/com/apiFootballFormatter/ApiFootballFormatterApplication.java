package com.apiFootballFormatter;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiFootballFormatterApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

		// Access the environment variables
		String username = dotenv.get("MYSQL_USER");
		String password = dotenv.get("MYSQL_PASSWORD");

		// Set the environment variables as system properties
		System.setProperty("MYSQL_USER", username);
		System.setProperty("MYSQL_PASSWORD", password);


		SpringApplication.run(ApiFootballFormatterApplication.class, args);
	}

}
