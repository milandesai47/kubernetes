package com.desai.order.order;

import orderproduct.OrderProductTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import product.ProductTO;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @Value("${product.service.host}")
    private String productServiceHost;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/{orderId}")
    public Order getOrder(@PathVariable("orderId") Integer orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping(path = "/info/{orderId}")
    public OrderProductTO getOrderProductInfo(@PathVariable("orderId") Integer orderId) {
        Order order = orderService.getOrder(orderId);
        final String uri = "http://"+ productServiceHost + ":8083/product/" + order.getProductId();
        RestTemplate restTemplate = new RestTemplate();
        ProductTO product = restTemplate.getForObject(uri, ProductTO.class);
        Integer total = order.getQuantity() * product.getPrice();
        return new OrderProductTO(product.getName(), total);
    }
}
