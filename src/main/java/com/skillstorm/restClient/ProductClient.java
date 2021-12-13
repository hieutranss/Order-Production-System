package com.skillstorm.restClient;

import com.skillstorm.beans.ProductC;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(path = "/products/v1", name = "PRODUCT-API")
public interface  ProductClient {

    @GetMapping("/product/{id}")
    public ProductC findById(@PathVariable int id);



}
