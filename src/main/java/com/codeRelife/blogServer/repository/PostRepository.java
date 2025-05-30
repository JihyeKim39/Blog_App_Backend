package com.codeRelife.blogServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeRelife.blogServer.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}