package com.skillstorm.service;

import java.util.ArrayList;
import java.util.List;

import com.skillstorm.beans.*;
import com.skillstorm.restClient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.repository.OrderRepository;
import com.skillstorm.repository.PizzaRepository;
import com.skillstorm.repository.ToppingRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	PizzaRepository pizzaRepo;
	
	@Autowired
	ToppingRepository toppingRepo;

	static final Logger log = LoggerFactory.getLogger(OrderService.class.getName());

//	@Autowired
//	private OrderClient orderClient;

	@Autowired
	private ProductClient productClient;


	public List<Order> findAll(){
		return repo.findAll();
	}
	
	@Transactional
	public void deleteById(Integer orderId) {		
		log.info("orderService deleteById called");

		toppingRepo.deleteToppingsByOrderID(orderId);
		pizzaRepo.deletePizzaByOrderId(orderId);
		repo.deleteByOrderId(orderId);		
	}
	
	public Order save(Order order) {
		return repo.save(order);
	}


	// Convert url for the products to actual values
//	public OrderC findOrderById(int id) {
//		log.debug("Start getting Order by id {}", id);
//		OrderC order = orderClient.findById(id);
//		return resolveOrderValues(order);
//	}
//
//	private OrderC resolveOrderValues(OrderC order) {
//		log.debug("Start resolve order values {}", order.getId());
//		List<OrderItem> orderItems= order.getOrderItems();
//		for(OrderItem orderItem: orderItems) {
//			orderItem.setCrust(resolveProductName(orderItem.getCrust()));
//			orderItem.setSize(resolveProductName(orderItem.getSize()));
//
//			List<String> newToppingList = new ArrayList<>();
//			for(String topping: orderItem.getToppings()) {
//				newToppingList.add(resolveProductName(topping));
//			}
//			orderItem.setToppings(newToppingList);
//		}
//
//		return order;
//	}

	public String resolveProductName(String productUrl) {
		log.debug("Start resolve product name {}", productUrl);
		String[] splitProductUrl = productUrl.split("/");
		int productId = Integer.parseInt(splitProductUrl[splitProductUrl.length-1]);
		return productClient.findById(productId).getName();
	}
	
	
}