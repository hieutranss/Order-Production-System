package com.skillstorm.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DispatchMessage {
    private int orderId;
    private String customerId;
    private String stage;
    private String readyForDispatch;
    private String type;

    public DispatchMessage(int orderId, String customerId, String stage, String readyForDispatch, String type) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.stage = stage;
        this.readyForDispatch = readyForDispatch;
        this.type = type;
    }

    public DispatchMessage() {
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

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getReadyForDispatch() {
        return readyForDispatch;
    }

    public void setReadyForDispatch(String readyForDispatch) {
        this.readyForDispatch = readyForDispatch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DispatchMessage{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", stage='" + stage + '\'' +
                ", readyForDispatch='" + readyForDispatch + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
