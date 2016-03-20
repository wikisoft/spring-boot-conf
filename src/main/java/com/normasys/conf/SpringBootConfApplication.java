package com.normasys.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = { "com.normasys.conf" })
//@Configuration
@SpringBootApplication
public class SpringBootConfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfApplication.class, args);
	}
}
