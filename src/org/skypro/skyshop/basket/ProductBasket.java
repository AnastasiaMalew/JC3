package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int costProduct;

    public ProductBasket() {
        this.products = new Product[5];
        this.costProduct = 0;
    }

    public void addProduct(Product product) {
        if (costProduct < products.length) {
            products[costProduct] = product;
            costProduct++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < costProduct; i++) {
            totalCost += products[i].getCostProduct();
        }
        return totalCost;
    }

    public void printBasketContents() {
        if (costProduct == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (int i = 0; i < costProduct; i++) {
                System.out.println(products[i].getProduct() + ": " + products[i].getCostProduct());
            }
            System.out.println("Итого: " + getTotalCost());
        }
    }
    public boolean containsProduct(String product) {
        for (int i = 0; i < costProduct; i++) {
            if
            (products[i].getProduct().equals(product)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i <costProduct; i++) {
            products[i] = null;
        }
        costProduct = 0;
    }
}
