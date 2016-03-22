package com.normasys.conf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("${health.my.entry}")
public class CheckBannerFile implements HealthIndicator {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public Health health() {
	if (!checkFile()) {
	    return Health.down().withDetail("Error Code ", -1).build();
	}
	return Health.up().build();
    }

    private boolean checkFile() {

	if (resourceLoader.getResource("classpath:banner.txt").exists()) {
	    return true;
	}
	return false;
    }

}
