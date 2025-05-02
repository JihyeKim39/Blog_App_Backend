package com.codeRelife.blogServer.service;

import java.util.List;

import com.codeRelife.blogServer.entity.Post;

public interface PostService {
	
	Post savePost(Post post); //메서드 언급하고, 메서드를 호출하기 위한 엔드포인트를 만들것이다
	
	List<Post> getAllPosts(); //메서드 언급, 이 메서드를 호출하는 엔드포인트 만들 것이다.
	
	Post getPostById(Long postId); 
}