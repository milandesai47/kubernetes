package com.desai.order.order;

public class Order {
    private int id;
    private int productId;
    private int cost;

    public Order(Integer id, Integer productId, Integer cost) {
        this.id = id;
        this.productId = productId;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
