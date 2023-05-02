package com.desai.order.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    private static final List<Order> ORDERS = Arrays.asList(
            new Order(1, 1, 1000),
            new Order(2, 2, 2000),
            new Order(3, 3, 3000)
    );

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/{orderId}")
    public Order getOrder(@PathVariable("orderId") Integer orderId){
        return orderService.getOrder(orderId);
    }
}
