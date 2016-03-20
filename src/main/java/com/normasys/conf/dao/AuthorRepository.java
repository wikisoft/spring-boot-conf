package com.normasys.conf.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.normasys.conf.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
