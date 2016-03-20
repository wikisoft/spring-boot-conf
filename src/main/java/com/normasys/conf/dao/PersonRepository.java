package com.normasys.conf.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.normasys.conf.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByName(@Param("name") String name);

}
