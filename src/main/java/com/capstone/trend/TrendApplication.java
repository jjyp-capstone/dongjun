package com.capstone.trend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TrendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendApplication.class, args);
	}

}
