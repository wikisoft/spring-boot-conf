package com.normasys.conf.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.normasys.conf.model.Author;

@RepositoryRestResource(path="/restAuthor")
public interface AuthorRepository extends MongoRepository<Author, String> {

}
