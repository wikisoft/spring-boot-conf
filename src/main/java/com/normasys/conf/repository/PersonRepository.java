package com.normasys.conf.repository;

import org.springframework.data.repository.CrudRepository;

import com.normasys.conf.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
