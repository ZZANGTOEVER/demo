package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.printf("-------------------- TEST --------------------");
		SpringApplication.run(DemoApplication.class, args);
	}

}
