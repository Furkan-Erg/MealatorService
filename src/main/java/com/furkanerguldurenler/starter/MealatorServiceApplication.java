package com.furkanerguldurenler.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.furkanerguldurenler"})
@EntityScan(basePackages = {"com.furkanerguldurenler"})
@EnableJpaRepositories(basePackages = {"com.furkanerguldurenler"})
@SpringBootApplication
public class MealatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealatorServiceApplication.class, args);
	}

} 
