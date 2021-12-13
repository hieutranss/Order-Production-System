package com.skillstorm.beans;


public class ProductC {
    private int id;
    private ProductType type;
    private String name;

    public ProductC(int id, ProductType type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public ProductC() {
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
