package com.desai.product.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product(1, "Apple", 1000),
            new Product(2, "Banana", 2000),
            new Product(3, "Orange", 3000)
    );

    @GetMapping(path = "/{productId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("productId") Integer productId){
        return PRODUCTS.stream()
                .filter(product -> productId.equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product " + productId + " does not exist"));

    }
}
