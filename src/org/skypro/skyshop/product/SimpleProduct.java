package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String product, double price) {
        super(product);
        this.price = price;
    }

    @Override
    public double getCostProduct() {
        return this.price;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}