# Order Production System

Order Production is the Java backend of SkillStorm Project 3 'PizzaStorm'. 
Ran with [Spring Boot](http://projects.spring.io/spring-boot/).

The order production will get data from service bus and store it in Azure Database for all products, and return them in a JSON object which can be easily converted to a POJO using [JSON2POJO](https://www.jsonschema2pojo.org). The complete product will be sent to the service bus for consuming.

There are other endpoints provided following the original endpoint `/makeline/v1`:
  * `@GetMapping()` which returns a JSON object listing all the available products.
  * `@PostMapping()` which returns a JSON object of a complete product, and send to service bus.
  * `@PutMapping("/pizza/{pizzaId}")` which changes the state of a pizza from incomplete to complete.

Product JSON:
```text
{
orderId: int,
customerId: int,
product: [{
 pizzaid: 
 crust:
 size:
 toppings []
}],
stage: created
created: DateTime,
type: delivery/carryout
}
```

  
Swagger Docs are available with the same information as above using `/swagger-ui` endpoint.

## Requirements

For building and running the application you need:

- [![Java](https://img.shields.io/badge/Java-v1.8-red.svg)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [![Maven 4](https://img.shields.io/badge/Maven-v4-white.svg)](https://maven.apache.org)
- [![Spring Boot](https://img.shields.io/badge/SpringBoot-v2.5.6-blue.svg)](http://projects.spring.io/spring-boot/)
