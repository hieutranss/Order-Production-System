package com.skillstorm.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.DispatchMessage;
import com.skillstorm.beans.Order;
import com.skillstorm.beans.OrderItemMessage;
import com.skillstorm.beans.OrderMessage;
import com.skillstorm.beans.Pizza;
import com.skillstorm.beans.Topping;
import com.skillstorm.repository.OrderRepository;
import com.skillstorm.repository.PizzaRepository;
import com.skillstorm.repository.ToppingRepository;

import com.skillstorm.service.*;

import reactor.core.publisher.Sinks;



@RestController
@RequestMapping("/makeline/v1")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService os;
	
	@Autowired
	PizzaService ps;

	@Autowired
	ToppingService ts;
	
	@Autowired
    private Sinks.Many<Message<DispatchMessage>> many;

	
	@GetMapping()
	public ResponseEntity<List<OrderMessage>> findAll() throws JsonParseException, JsonMappingException, IOException {	
		
		List<Order> or = new ArrayList<>();
		or = os.findAll();
		
		List<Pizza> pi = new ArrayList<>();
		pi = ps.findAll();
		
		List<Topping> topp = new ArrayList<>();
		topp = ts.findAll();
			
		List <OrderMessage> om = new ArrayList <OrderMessage>();
		
		for(Order o : or) {
			OrderMessage tempOrder = new OrderMessage();
			tempOrder.setCustomerId(o.getCustomerId());
			tempOrder.setType(o.getType());
			tempOrder.setOrderId(o.getOrderId());
			tempOrder.setStage(o.getStage());
			tempOrder.setCreated(o.getCreated());
			List <OrderItemMessage> oimList = new ArrayList <OrderItemMessage>();
			for(Pizza p : pi ) {
				if (p.getOrderId() == o.getOrderId()) {
					OrderItemMessage tempOim = new OrderItemMessage();
					tempOim.setCrust(p.getCrust());
					tempOim.setPizzaId(p.getId());
					tempOim.setSize(p.getSize());
					tempOim.setIsCompleted(p.IsCompleted());
					List<String> toppings = new ArrayList<>();
					for(Topping to : topp) {
						if(p.getId() == to.getPizzaId()) {
							toppings.add(to.getDescription());
						}
				    }
					// Set toppings
					tempOim.setToppings(toppings);  
					// Add the product to the product list
					oimList.add(tempOim);  
				}	
			}

			// Add list of products to the current order
			tempOrder.setProduct(oimList); 
			// Add current order to the list of Orders
			om.add(tempOrder); 

		}
		log.info("Display all orders in database " + om);
		return new ResponseEntity<>(om, HttpStatus.OK);
	}
	
	@PostMapping()
    public ResponseEntity<Void> produceOrder(@RequestBody OrderMessage order) {

    	//process order from make line into order.produced message and publish it to a topic

        log.info("Received updated order from front end {} " + order );
        many.emitNext(MessageBuilder.withPayload(new DispatchMessage(order.getOrderId(), order.getCustomerId(),
                order.getStage(), order.getCreated(), order.getType())).build(), Sinks.EmitFailureHandler.FAIL_FAST);
        
        log.info(order.toString());
        //delete an order in database
        os.deleteById(order.getOrderId());
        
        return ResponseEntity.ok().build();
        //process order into order.produced message format
        //send it
    }
	
	@PutMapping("/pizza/{pizzaId}")
	public ResponseEntity<Void> producePizza(@PathVariable int pizzaId){
		//change the state of the pizza from incomplete to complete		
		log.info("Pizza: " + pizzaId + " is complete.");
		ps.completePizza(pizzaId);
		
		return ResponseEntity.ok().build();
	}
	
	

}
