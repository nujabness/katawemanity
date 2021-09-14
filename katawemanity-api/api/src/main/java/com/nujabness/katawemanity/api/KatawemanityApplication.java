package com.nujabness.katawemanity.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = { "com.nujabness.katawemanity" })
public class KatawemanityApplication {

	public static void main(String[] args) {
		SpringApplication.run(KatawemanityApplication.class, args);
	}

}
