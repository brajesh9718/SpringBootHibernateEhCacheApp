package com.mytech.springboot.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Brajesh Pandey
 * Main implementation class which serves following purpose in a spring boot application: 
 * 		a. Configuration and bootstrapping.
 * 		b. Enables the cache-management ability in a spring framework.
 */
@SpringBootApplication
@EnableCaching
public class Myapplication {

	public static void main(String[] args) {
		SpringApplication.run(Myapplication.class, args);
	}
}