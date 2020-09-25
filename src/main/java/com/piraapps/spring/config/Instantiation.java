package com.piraapps.spring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.piraapps.spring.domain.Coment;
import com.piraapps.spring.domain.Post;
import com.piraapps.spring.domain.User;
import com.piraapps.spring.dto.AuthorDTO;
import com.piraapps.spring.repository.PostRepository;
import com.piraapps.spring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "maria", "maria@gmail.com");
		User alex = new User(null, "alex", "alex@gmail.com");
		User bob = new User(null, "bob", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Feliz hoje", new AuthorDTO(maria));

		Coment coment1 = new Coment("Boa viagem", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		Coment coment2 = new Coment("Aproveite", sdf.parse("22/03/2020"), new AuthorDTO(bob));
		Coment coment3 = new Coment("Otimo dia", sdf.parse("23/03/2020"), new AuthorDTO(bob));
		
		post1.getComents().addAll(Arrays.asList(coment1, coment2));
		post2.getComents().addAll(Arrays.asList(coment3));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
