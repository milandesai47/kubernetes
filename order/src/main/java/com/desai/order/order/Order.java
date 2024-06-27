package com.desai.order.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Order {

    @Id
    private long id;
    private Date date;
    private Integer productId;
    private Integer quantity;

    public Order(Integer id, Date date, Integer productId, Integer quantity) {
        this.id = id;
        this.date = date;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
