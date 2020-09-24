package com.piraapps.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piraapps.spring.domain.User;
import com.piraapps.spring.dto.UserDTO;
import com.piraapps.spring.repository.UserRepository;
import com.piraapps.spring.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);		
	}
	
	public void delete(String id) {
		this.findById(id);
		repo.deleteById(id);
	}
	
	public void update(User user) {
		User newUser = findById(user.getId());
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		repo.save(user);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
