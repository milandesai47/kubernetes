package com.desai.order.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping(path="/{productId}")
    public Object getProduct(@PathVariable("productId") Integer productId) {
        final String uri = "http://localhost:8083/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
