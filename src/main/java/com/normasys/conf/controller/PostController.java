package com.normasys.conf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.normasys.conf.model.Author;
import com.normasys.conf.model.Comment;
import com.normasys.conf.model.Person;
import com.normasys.conf.model.Post;
import com.normasys.conf.service.PostService;

@RestController
@RequestMapping("/rest")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/postSize", method = RequestMethod.GET)
    public @ResponseBody int getPostCount() {
	return postService.getPosts().size();
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public @ResponseBody Post getPost(@PathVariable("id") final String id) {
	return postService.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public @ResponseBody List<Post> getPostList() {
	return postService.getPosts();
    }

    @RequestMapping(value = "/savePost", method = RequestMethod.POST)
    public @ResponseBody List<Post> savePost(@RequestBody final Post post) {
	return saveOrUpdatePost(post);
    }

    @RequestMapping(value = "/upvotePost/{up}", method = RequestMethod.POST)
    public @ResponseBody List<Post> upvotePost(@RequestBody final Post post,
	    @PathVariable("up") final boolean isUP) {
	if (isUP) {
	    post.setUpvotes(post.getUpvotes() + 1);
	} else {
	    post.setUpvotes(post.getUpvotes() - 1);
	}
	return saveOrUpdatePost(post);
    }

    private List<Post> saveOrUpdatePost(final Post post) {
	postService.save(post);
	return postService.getPosts();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public @ResponseBody List<Post> deletePost(@RequestBody final Post post) {
	postService.deletePost(post);
	return postService.getPosts();
    }

    // comments
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public @ResponseBody List<Comment> getComments() {
	return postService.getComments();
    }
    
    
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public @ResponseBody Comment getComment(@PathVariable("id") final String id) {
	return postService.getComment(id);
    }

    @RequestMapping(value = "/saveComment/{postId}", method = RequestMethod.POST)
    public @ResponseBody Post saveComment(@RequestBody final Comment comment,
	    @PathVariable("postId") final String postId) {

	Post post = postService.getPost(postId);

	comment.setDate(new Date());
	postService.save(comment);

	post.addComment(comment);
	postService.save(post);
	return post;
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public @ResponseBody List<Comment> deleteComment(
	    @RequestBody final Comment comment) {
	postService.deleteComment(comment);
	return postService.getComments();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/upvoteComment/{isUp}/{postId}", method = RequestMethod.POST)
    public @ResponseBody Post upvoteComment(@RequestBody final Comment comment,
	    @PathVariable("isUp") final boolean isUP,
	    @PathVariable("postId") final String postId) {
	if (isUP) {
	    comment.setUpvotes(comment.getUpvotes() + 1);
	} else {
	    comment.setUpvotes(comment.getUpvotes() - 1);
	}
	postService.save(comment);
	return postService.getPost(postId);
    }

    // Authors
    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public @ResponseBody Author getAuthor(@PathVariable("id") final String id) {
	return postService.getAuthor(id);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public @ResponseBody List<Author> getAuthorList() {
	return postService.getAuthors();
    }

    @RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
    public @ResponseBody List<Author> saveAuthor(
	    @RequestBody final Author author) {
	postService.save(author);
	return postService.getAuthors();
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    public @ResponseBody List<Author> deleteAuthor(
	    @RequestBody final Author author) {
	postService.deleteAuthor(author);
	return postService.getAuthors();
    }
    
    // Persons
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public @ResponseBody Person getPerson(@PathVariable("id") final String id) {
	return postService.getPerson(id);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public @ResponseBody List<Person> getPersonList() {
	return postService.getPersons();
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public @ResponseBody List<Person> savePerson(
	    @RequestBody final Person person) {
	postService.save(person);
	return postService.getPersons();
    }

    @RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
    public @ResponseBody List<Person> deletePerson(
	    @RequestBody final Person person) {
	postService.deletePerson(person);
	return postService.getPersons();
    }

}
