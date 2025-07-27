package org.skypro.skyshop.product;
import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {
    private String name;
    private double price;

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract double getCostProduct();

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
        this.name = name;
    }

    public abstract boolean isBetter(Searchable bestResult);

    public Product(String name, double price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена продукта не может быть отрицательной.");
        }
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }
}