package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String product, double price) {
        super(product);
        this.price = price;
    }

    public SimpleProduct(String product) {
        super(product);
    }

    @Override
    public boolean isBetter(Searchable bestResult) {
        return false;
    }

    @Override
    public double getCostProduct() {
        return this.price;
    }

    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public boolean isSpecial() {
        return false;
    }
    public static void main(String[] args) {
        try {
            SimpleProduct product = new SimpleProduct("Товар", 10); // Корректное значение
            SimpleProduct invalidProduct = new SimpleProduct("Некорректный товар", 0); // Некорректное значение
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getSearchString() {
        return "";
    }
}