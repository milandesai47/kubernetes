package com.desai.order.order;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private static final List<Order> ORDERS = Arrays.asList(
            new Order(1, 1, 1000),
            new Order(2, 2, 2000),
            new Order(3, 3, 3000),
            new Order(4, 4, 4000)
    );

    public Order getOrder(Integer orderId) {
        return ORDERS.stream()
                .filter(order -> orderId.equals(order.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Order " + orderId + " does not exist"));
    }
}
