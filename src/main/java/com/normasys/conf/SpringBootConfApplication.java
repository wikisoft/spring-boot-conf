package com.normasys.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.normasys.conf.config.SpringMongoConfig;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = { "com.normasys.conf" })
//@Configuration
@SpringBootApplication(scanBasePackages = { "com.normasys.conf" })
@Import({SpringMongoConfig.class })
public class SpringBootConfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfApplication.class, args);
	}
}
