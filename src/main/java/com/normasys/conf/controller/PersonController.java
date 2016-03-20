package com.normasys.conf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.normasys.conf.model.Person;
import com.normasys.conf.repository.PersonRepository;

@RestController
@RequestMapping("/rest")
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;
    
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public @ResponseBody Person getPerson(@PathVariable("id") final String id) {
	return personRepository.findOne(Long.valueOf(id));
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public @ResponseBody List<Person> getPersonList() {
	return Lists.newArrayList(personRepository.findAll());
    }

}
