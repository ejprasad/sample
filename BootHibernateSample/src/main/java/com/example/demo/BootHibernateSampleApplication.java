package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan({"com.example.demo","com.example.model.dao","com.example.model.entity","com.example.model.service","com.example.controller"})
@EntityScan(basePackages= {"com.example.model.entity"})
@Configuration
public class BootHibernateSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootHibernateSampleApplication.class, args);
	}

}

