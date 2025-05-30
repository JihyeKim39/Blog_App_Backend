package com.codeRelife.blogServer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeRelife.blogServer.entity.Post;
import com.codeRelife.blogServer.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl implements PostService {  // ← 여기서 인터페이스 구현도 가능해!

	@Autowired
	private PostRepository postRepository;
	
	public Post savePost(Post post) {
		post.setLikeCount(0);
		post.setViewCount(0);
		post.setDate(new Date());
		
		return postRepository.save(post);
	}
	
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	
	// 게시물 id 로 찾기 
	public Post getPostById(Long postId) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			post.setViewCount(post.getViewCount() +1);
			return postRepository.save(post);
		} else {
			throw new EntityNotFoundException("Post Not Found");
		}
	}
  
}