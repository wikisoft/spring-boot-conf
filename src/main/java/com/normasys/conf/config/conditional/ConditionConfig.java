package com.normasys.conf.config.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@ConditionalOnClass({ TestConditionalConfig.class })
public class ConditionConfig implements Ordered{
    
    @Override
    public int getOrder() {
	return Integer.MAX_VALUE;
    }
    
    @Bean
    public String textBean() {
	return "textBean";
    }
    
    @Bean
    public int numberBean() {
	return 123;
    }
    
    @Bean
    @ConditionalOnMissingBean(name = "textBean")
    @ConditionalOnBean(name = "numberBean")
    public String testConditionConfig() {
        return "Hello From conditional Bean";
    }
    



    

}



