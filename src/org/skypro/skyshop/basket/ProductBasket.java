package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
        int specialCount = 0;
        if (costProduct == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (int i = 0; i < costProduct; i++) {
                if (products[i].isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Количество специальных товаров в корзине: " + specialCount);
        }
    }

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        SimpleProduct apple = new SimpleProduct("Яблоки", 45);
        SimpleProduct meat = new SimpleProduct("Мясо", 150);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 10, 115);
        DiscountedProduct egg = new DiscountedProduct("Яйцо", 15, 54);
        FixPriceProduct chocolate = new FixPriceProduct("Шоколад");

        basket.addProduct(apple);
        basket.addProduct(meat);
        basket.addProduct(milk);
        basket.addProduct(egg);
        basket.addProduct(chocolate);

        basket.printBasketContents();
    }

    public int printContents() {
        return 0;
    }
}