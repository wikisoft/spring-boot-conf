package com.normasys.conf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    
    @Autowired(required=false)
    private String testConditionConfig;
    
    @RequestMapping(value="/HelloFromMyCustomBean", method = RequestMethod.GET)
    public String HelloFromMyCustomBean(){
	return testConditionConfig;
    }
    

}
