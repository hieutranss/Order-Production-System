package com.skillstorm.config;



import com.skillstorm.beans.*;

import com.skillstorm.repository.OrderRepository;
import com.skillstorm.repository.PizzaRepository;
import com.skillstorm.repository.ToppingRepository;
import com.skillstorm.service.OrderService;
import com.skillstorm.service.PizzaService;
import com.skillstorm.service.ToppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Consumer;
import java.util.function.Supplier;


@Configuration
public class ServiceBusTopicConfig {

    //The below line will be commented as web socket has been replaced with pull calls
//    @Autowired
//    private SimpMessageSendingOperations messagingTemplate;

    private final Logger log = LoggerFactory.getLogger(ServiceBusTopicConfig.class.getName());

    @Autowired
    private OrderService orderService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ToppingService toppingService;

    @Bean
    public Consumer<Message<OrderMessage>> newOrderConsumer() {
        return message -> {

            log.info("Receive new order {}",message.getPayload());
            if (message.getPayload().getStage().equalsIgnoreCase( "created")) {
//                orderService.findOrderById(message.getPayload().getOrderId());
                //save new order, pizza, topping to azure DB

                //create new order
                Order newOrder = new Order();
                newOrder.setOrderId(message.getPayload().getOrderId());
                newOrder.setCustomerId(message.getPayload().getCustomerId());
                newOrder.setCreated(message.getPayload().getCreated());
                newOrder.setStage(message.getPayload().getStage());
                newOrder.setType(message.getPayload().getType());

                orderService.save(newOrder); // saves order in azure db

                // create new pizza from each order item message from the payload
                for(OrderItemMessage oim: message.getPayload().getProduct()) {
                    Pizza newPizza = new Pizza();
                    newPizza.setOrderId(message.getPayload().getOrderId());
                    newPizza.setId(oim.getPizzaId());
                    newPizza.setCrust(oim.getCrust());
                    newPizza.setSize(oim.getSize());
                    newPizza.setIsCompleted(false);
                    pizzaService.save(newPizza);
                    // create new toppings for each pizza from order item message's list of toppings

                    for(String topping: oim.getToppings()) {
                        Topping newTopping = new Topping();
                        newTopping.setPizzaId(oim.getPizzaId());
                        newTopping.setDescription(topping);
                        toppingService.save(newTopping);
                    }
                }

                //The below line will be commented as web socket has been replaced with pull calls
//                messagingTemplate.convertAndSend("/order-production-topic/order", message.getPayload());
                log.info("Receive new order {}",message);

            }
        };
    }

    @Bean
    public Sinks.Many<Message<DispatchMessage>> many() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<Message<DispatchMessage>>> producedOrderPublisher(Sinks.Many<Message<DispatchMessage>> many) {
        return () -> many.asFlux()
                .doOnNext(m -> log.info("Sending produced order message {}", m))
                .doOnError(t -> log.error("Error encountered while sending produced order", t));
    }

}
