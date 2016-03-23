package com.normasys.conf.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.normasys.conf.dao.AuthorRepository;
import com.normasys.conf.dao.CommentRepository;
import com.normasys.conf.dao.PersonRepository;
import com.normasys.conf.dao.PostRepository;
import com.normasys.conf.model.Author;
import com.normasys.conf.model.Comment;
import com.normasys.conf.model.Person;
import com.normasys.conf.model.Post;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PersonRepository personRepository;

    @Value("custom.myValue")
    private String customValue;

    // posts
    public List<Post> getPosts() {
	return postRepository.findAll();
    }

    public Post getPost(final String id) {
	return postRepository.findOne(id);
    }

    public void save(final Post post) {
	postRepository.save(post);
    }

    public void deleteAllPosts() {
	postRepository.deleteAll();
    }

    public void deletePost(final Post post) {
	postRepository.delete(post);
    }

    // Comments
    public List<Comment> getComments() {
	return commentRepository.findAll();
    }

    public Comment getComment(final String id) {
	return commentRepository.findOne(id);
    }

    public void save(final Comment comment) {
	commentRepository.save(comment);
    }

    public void deleteAllComments() {
	commentRepository.deleteAll();
    }

    public void deleteComment(final Comment comment) {
	commentRepository.delete(comment);
    }

    // authors
    public List<Author> getAuthors() {
	return authorRepository.findAll();
    }

    public Author getAuthor(final String id) {
	return authorRepository.findOne(id);
    }

    public void save(final Author author) {
	authorRepository.save(author);
    }

    public void deleteAllAuthors() {
	authorRepository.deleteAll();
    }

    public void deleteAuthor(final Author author) {
	authorRepository.delete(author);
    }

    // Persons
    public List<Person> getPersons() {
	return personRepository.findAll();
    }

    public Person getPerson(final String id) {
	return personRepository.findOne(id);
    }

    public void save(final Person person) {
	personRepository.save(person);
    }

    public void deleteAllPersons() {
	personRepository.deleteAll();
    }
    
    public void deletePerson(final Person person) {
	personRepository.delete(person);
    }

    public String convertDate(Date date) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	return dateFormat.format(date);
    }

}
