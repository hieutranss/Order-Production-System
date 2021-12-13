package com.skillstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.beans.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	

	public Order save(Order order);
	
//    @Modifying
//    @Transactional
//	@Query(value = "delete from orders where orders.order_id = ?1", nativeQuery = true)	
//	public void delete(Integer orderId);

    @Modifying
    @Transactional
    @Query(value = "DELETE orders FROM orders INNER JOIN pizza INNER JOIN topping WHERE pizza.order_id = orders.order_id AND topping.pizza_id = pizza.pizza_id AND orders.order_id = ?1", nativeQuery = true)
    public void deleteCascade(int orderId);
	
	@Modifying
	@Query(value = "DELETE FROM orders WHERE orders.order_id = ?1", nativeQuery = true)	
	public void deleteByOrderId(int orderId);

	
}