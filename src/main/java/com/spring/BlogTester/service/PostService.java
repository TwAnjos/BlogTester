package com.spring.BlogTester.service;

import java.util.List;
import com.spring.BlogTester.model.Post;

public interface PostService {

	List<Post> GetAll();
	Post GetById(long id);
	Post Insert(Post post);
}
