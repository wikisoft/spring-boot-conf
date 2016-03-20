package com.normasys.conf.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.normasys.conf.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title' : ?0 }")
    List<Post> findByPostTitle(@Param("title") String title);

}
