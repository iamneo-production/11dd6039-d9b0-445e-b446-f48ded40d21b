package net.striker.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.striker.backend.model.product;
import net.striker.backend.repository.productRepository;

@Service
public class productservice {
	

		@Autowired
		productRepository repo;

		public product saveuser(product productdetail) {
			// TODO Auto-generated method stub
			return repo.save(productdetail);
		}

		public List<product> findAll() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}
	}


