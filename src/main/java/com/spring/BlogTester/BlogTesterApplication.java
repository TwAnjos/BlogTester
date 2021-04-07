package com.spring.BlogTester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//deixar original quando não estiver em teste
//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BlogTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogTesterApplication.class, args);
	}

}
