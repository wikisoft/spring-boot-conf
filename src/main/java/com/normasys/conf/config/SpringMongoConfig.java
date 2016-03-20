package com.normasys.conf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.normasys.conf.dao.listener.CommentCascadeDeleteMongoEventListener;

@EnableMongoRepositories(basePackages = { "com.normasys.conf.dao" })
public class SpringMongoConfig {

    public @Bean CommentCascadeDeleteMongoEventListener commentCascadingMongoEventListener() {
	return new CommentCascadeDeleteMongoEventListener();
    }

}
