package com.codeRelife.blogServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeRelife.blogServer.entity.Post;
import com.codeRelife.blogServer.service.PostService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/posts") 
@CrossOrigin (origins = "*") //모든 출처에서 api 호출 허용해주기 
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody Post post){
		
		try {
			Post createdPost = postService.savePost(post);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts(){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping ("/{postId}")
	public ResponseEntity<?> getPostById (@PathVariable Long postId ){
		try {
			Post post = postService.getPostById(postId);
			return ResponseEntity.ok(post);	
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}