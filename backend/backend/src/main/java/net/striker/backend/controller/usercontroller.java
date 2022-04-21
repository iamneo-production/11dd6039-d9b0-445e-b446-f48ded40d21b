package net.striker.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.striker.backend.model.user;
import net.striker.backend.repository.userRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class usercontroller {
	@Autowired
       private userRepository UserRepository;
	@GetMapping("/users")
	public List<user> getAlluser(){
		return UserRepository.findAll();
		
	}
}
