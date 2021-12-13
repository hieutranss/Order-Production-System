package com.skillstorm.beans;

import java.io.Serializable;
import java.util.List;

public class OrderMessage implements Serializable {
    private int orderId;
    private String customerId;
    private List<OrderItemMessage> product;
    private String stage;
    private String created;
    private String type;


    public OrderMessage() {
    }

    public OrderMessage(int orderId, String customerId, List<OrderItemMessage> product, String stage, String created, String type) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.product = product;
        this.stage = stage;
        this.created = created;
        this.type = type;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemMessage> getProduct() {
        return product;
    }

    public void setProduct(List<OrderItemMessage> product) {
        this.product = product;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "OrderMessage{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", product=" + product +
                ", stage='" + stage + '\'' +
                ", timeStamp=" + created +
                ", method='" + type + '\'' +
                '}';
    }
}
