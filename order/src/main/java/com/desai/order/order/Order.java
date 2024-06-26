package com.desai.order.order;

import java.util.Date;

public class Order {
    private int id;
    private Date date;
    private Integer productId;
    private Integer quantity;

    public Order(Integer id, Date date, Integer productId, Integer quantity) {
        this.id = id;
        this.date = date;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
