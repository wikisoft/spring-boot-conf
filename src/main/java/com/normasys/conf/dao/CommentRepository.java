package com.normasys.conf.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.normasys.conf.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
