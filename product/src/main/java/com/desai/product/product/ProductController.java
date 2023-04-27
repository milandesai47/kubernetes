package com.desai.product.product;

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
            new Product(1, "productA", 1000),
            new Product(2, "productB", 2000),
            new Product(3, "productC", 3000)
    );

    @GetMapping(path = "/{productId}")
    public Product getStudent(@PathVariable("productId") Integer productId){
        return PRODUCTS.stream()
                .filter(product -> productId.equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product " + productId + " does not exist"));

    }
}
