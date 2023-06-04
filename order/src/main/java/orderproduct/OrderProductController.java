package orderproduct;


import com.desai.order.order.Order;
import com.desai.order.order.OrderService;
import product.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order/product")
public class OrderProductController {

    @Value("${product.service.host}")
    private String productServiceHost;

    private final OrderService orderService;

    public OrderProductController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/{orderId}")
    public OrderProduct getOrderProductInfo(@PathVariable("orderId") Integer orderId) {
        Order order = orderService.getOrder(orderId);
        final String uri = "http://"+ productServiceHost + ":8083/product/" + order.getProductId();
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(uri, Product.class);
        Integer total = order.getQuantity() * product.getPrice();
        return new OrderProduct(product.getName(), total);
    }
}
