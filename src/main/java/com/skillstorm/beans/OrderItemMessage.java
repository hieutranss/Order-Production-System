package com.skillstorm.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderItemMessage implements Serializable {

    private int pizzaId;
    private String size;
    private String crust;
    private List<String> toppings;
    private boolean isCompleted;

    public OrderItemMessage() {
    }

    public OrderItemMessage(int pizzaId, String size, String crust, List<String> toppings, boolean isCompleted) {
        this.pizzaId = pizzaId;
        this.crust = crust;
        this.size = size;
        this.toppings = toppings;
        this.isCompleted = isCompleted;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }


    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "OrderItemMessage{" +
                "pizzaId=" + pizzaId +
                ", crust='" + crust + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
