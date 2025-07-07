package org.skypro.skyshop.product;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;

public abstract class Product implements Searchable {
    private String name;

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
}