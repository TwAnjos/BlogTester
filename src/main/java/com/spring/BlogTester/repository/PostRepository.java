package com.spring.BlogTester.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.BlogTester.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
