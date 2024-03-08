package org.example.cv_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Cv03Application {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Cv03Application.class, args);
	}

}
