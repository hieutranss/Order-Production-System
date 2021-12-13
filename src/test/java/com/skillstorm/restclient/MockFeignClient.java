package com.skillstorm.restclient;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public class MockFeignClient {

//    @RestController
//    @EnableFeignClients(clients = OrderClient.class)
//    @RibbonClient(name = "order-api", configuration = MockFeignClient.RibbonConfig.class)
//    public static class MockOrderClient {
//        @RequestMapping(value = "/orders/v1/order/{id}")
//        public String testGetOrderById(int id) {
//
//            return "Success";
//
//        }
//
//    }

//    @EnableFeignClients(clients = ProductClient.class)
//    @RibbonClient(name = "product-api", configuration = MockFeignClient.RibbonConfig.class)
//    @Configuration
//    @EnableAutoConfiguration
//    public static class MockProductClient {
//        @RequestMapping(value = "/products/v1/product/{id}")
//        public String testGetProductById(int id) {
//            if(id==1) {
//                return "{\n" +
//                        "    \"product_id\": 1,\n" +
//                        "    \"type\": {\n" +
//                        "        \"type_id\": 1,\n" +
//                        "        \"name\": \"Crust\"\n" +
//                        "    },\n" +
//                        "    \"name\": \"Thin\"\n" +
//                        "}";
//            }
//            if(id==2) {
//                return "{\n" +
//                        "    \"product_id\": 2,\n" +
//                        "    \"type\": {\n" +
//                        "        \"type_id\": 2,\n" +
//                        "        \"name\": \"Size\"\n" +
//                        "    },\n" +
//                        "    \"name\": \"12\\\"\"\n" +
//                        "}";
//            }
//            if(id==3) {
//                return "{\n" +
//                        "    \"product_id\": 3,\n" +
//                        "    \"type\": {\n" +
//                        "        \"type_id\": 3,\n" +
//                        "        \"name\": \"Topping\"\n" +
//                        "    },\n" +
//                        "    \"name\": \"Black Olives\"\n" +
//                        "}";
//            }
//            else
//                return null;
//        }
//
//    }
//
//    @Configuration
//    static class RibbonConfig {
//
////        @LocalServerPort
////        int port;
//
//        @Bean
//        public ServerList<Server> serverList() {
//            return new StaticServerList<>(new Server("127.0.0.1", 9004), new Server("127.0.0.1", 9003));
//        }
//    }
}