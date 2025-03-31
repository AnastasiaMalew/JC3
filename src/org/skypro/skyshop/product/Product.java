package org.skypro.skyshop.product;

public abstract class Product {
    private final String product;

    public Product(String product) {
        this.product = product;
    }
    public String getProduct() {
        return product;
    }
    public abstract double getCostProduct();

    public abstract double getPrice();

    public abstract boolean isSpecial();
}