package com.spring.BlogTester.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.BlogTester.model.Post;
import com.spring.BlogTester.repository.PostRepository;
import com.spring.BlogTester.service.PostService;

@Service
@RestController
@RequestMapping("/tw")
public class PostImpl implements PostService {

	@Autowired
	PostRepository pr;
	
	@Override
	public List<Post> GetAll() {
		return pr.findAll();
	}

	@Override
	public Post GetById(long id) {
		return pr.findById(id).get();
	}

	@Override
	public Post Insert(Post post) {
		return pr.save(post);
	}
	
	@GetMapping(value = "/getTw")
	public String getTw() {
		return "PISÃO!!!!";
	}

}
