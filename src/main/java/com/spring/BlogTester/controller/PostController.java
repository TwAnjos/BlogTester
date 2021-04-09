package com.spring.BlogTester.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//newpost foi redirecionado para postform.html
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			
			attributes.addFlashAttribute("mensagemErro", "Verifique se os campos obrigatórios foram preenchidos!");
			
			System.err.println("Formulário incompleto "+LocalDate.now() +" "+LocalTime.now());
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		iPostService.Insert(post);
		
		return "redirect:/posts";
	}
	
	
	
	
	@RequestMapping(value = "/getTw", method = RequestMethod.GET)
	public String getTw() {
		return "PISÃO!!!!"; //thymeleaf acha que isso é um template
	}

}
