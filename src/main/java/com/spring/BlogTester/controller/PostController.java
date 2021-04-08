package com.spring.BlogTester.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.BlogTester.model.Post;
import com.spring.BlogTester.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService iPostService;
	
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		//ModelAndView mv = new ModelAndView( viewName: "posts");
		ModelAndView mv = new ModelAndView("posts"); //posts.html
		List<Post> posts = iPostService.GetAll();
		//mv.addObject(attributeName: "posts", posts);
		mv.addObject("mvListPosts", posts);
		return mv;
	}
	
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostById(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails"); //postDetails.html
		Post postId = iPostService.GetById(id);
		mv.addObject("mvPostId", postId);
		return mv;
	}
	
	
	
	
	
	@GetMapping(value = "/getTw")
	public String getTw() {
		return "PISÃO!!!!";
	}

}
