package com.spring.BlogTester.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.BlogTester.model.Post;
import com.spring.BlogTester.repository.PostRepository;

@Component
public class DummyData {

	@Autowired
	PostRepository pr;

	//@PostConstruct	//Executa esse metodo no momento que inicia a aplicação
	public void savePosts() {

		List<Post> postList = new ArrayList<>();
		Post p1 = new Post();

		p1.setAutor("User 1");
		p1.setData(LocalDate.now());
		p1.setTitulo("Ipsum");
		p1.setTexto(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

		Post p2 = new Post();
		p2.setAutor("User 2");
		p2.setData(LocalDate.now());
		p2.setTitulo("Lorem");
		p2.setTexto(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

		//postList.add(p1);
		//postList.add(p2);
		
		postList.addAll(Arrays.asList(p1,p2));
		
		for (Post post : postList) {
			Post postSaved = pr.save(post);
			System.out.println("Titulo: "+postSaved.getTitulo()+" - ID: "+postSaved.getId());
		}

	}

}
