package product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/product")
public class ProductController {

    @Value("${product.service.host}")
    private String productServiceHost;

    @GetMapping(path="/{productId}")
    public Object getProduct(@PathVariable("productId") Integer productId) {
        final String uri = "http://" + productServiceHost + ":8083/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
