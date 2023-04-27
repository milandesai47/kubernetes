package com.desai.order.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private static final List<Order> ORDERS = Arrays.asList(
            new Order(1, 100, 1000),
            new Order(2, 200, 2000),
            new Order(3, 3, 3000)
    );

    @GetMapping(path = "/{orderId}")
    public Order getStudent(@PathVariable("orderId") Integer orderId){
        return ORDERS.stream()
                .filter(order -> orderId.equals(order.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Order " + orderId + " does not exist"));

    }
}
