package com.normasys.conf.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = { "com.normasys.conf" })
//@Configuration
@SpringBootApplication(scanBasePackages = { "com.normasys.conf" })
@Import({SpringMongoConfig.class })
public class AppConfig {

}
