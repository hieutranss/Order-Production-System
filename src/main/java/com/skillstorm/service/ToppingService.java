package com.skillstorm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Order;
import com.skillstorm.beans.Pizza;
import com.skillstorm.beans.Topping;
import com.skillstorm.repository.PizzaRepository;
import com.skillstorm.repository.ToppingRepository;

@Service
public class ToppingService {

	@Autowired
	ToppingRepository repo;
	
	public List<Topping> findAll(){
		return repo.findAllTopping();
	}
	
	public Topping save(Topping topping) {
		return repo.save(topping);
	}
	
	


}
