package orderproduct;


import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderProductTO {

    @JsonProperty
    private final String productName;

    @JsonProperty
    private final Integer total;

    public OrderProductTO(String productName, Integer total) {
        this.productName = productName;
        this.total = total;
    }

}
