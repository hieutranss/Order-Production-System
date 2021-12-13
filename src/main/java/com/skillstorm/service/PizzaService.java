package com.skillstorm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Order;
import com.skillstorm.beans.Pizza;
import com.skillstorm.repository.OrderRepository;
import com.skillstorm.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	PizzaRepository repo;
	
	public List<Pizza> findAll(){
		return repo.findAll();
	}
	
	public Pizza save(Pizza pizza) {
		return repo.save(pizza);

	}

	public void completePizza(Integer pizzaId) {
		repo.completePizza(pizzaId);
	}	
	
}
