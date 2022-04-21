package net.striker.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.striker.backend.model.product;
import net.striker.backend.service.productservice;
//import net.striker.backend.repository.productRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/")


public class productcontroller {
	
	
		
		@Autowired
		productservice productservices;
		//private userRepository UserRepository;
		
		@GetMapping("/products")
		public List<product> getUsers(){
			//return this.UserRepository.findAll();
			return productservices.findAll();
		}
		
		@PostMapping("saveproducts")
		public product postproduct(@RequestBody product productdetail) {
		
			return productservices.saveuser(productdetail);
		}
	}

