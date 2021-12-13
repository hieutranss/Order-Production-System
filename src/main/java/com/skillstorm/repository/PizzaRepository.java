package com.skillstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.beans.Order;
import com.skillstorm.beans.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	

	public Pizza save(Pizza pizza);

	@Modifying
	@Transactional
	@Query(value = "update pizza set pizza.is_completed = 1 where pizza_id = ?1", nativeQuery = true)
	void completePizza(Integer pizzaId);

	@Modifying
	@Query(value = "DELETE pizza FROM pizza INNER JOIN orders WHERE pizza.order_id = orders.order_id AND orders.order_id = ?1", nativeQuery = true)
	public void deletePizzaByOrderId(int orderId);
	
}