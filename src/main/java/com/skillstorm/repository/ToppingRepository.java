package com.skillstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.beans.Pizza;
import com.skillstorm.beans.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer>{
	

	public Topping save(Topping topping);

	@Query(value = "SELECT * from pizza , topping WHERE pizza.pizza_id = topping.pizza_id", nativeQuery = true)	
	public List<Topping> findAllTopping();
	
	@Modifying
	@Query(value = "DELETE topping FROM topping INNER JOIN pizza INNER JOIN orders WHERE pizza.order_id = orders.order_id AND topping.pizza_id = pizza.pizza_id AND orders.order_id = ?1", nativeQuery = true)
	public void deleteToppingsByOrderID(int orderId);
	
}
