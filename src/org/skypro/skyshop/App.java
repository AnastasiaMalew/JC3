package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
            ProductBasket basket = new ProductBasket();

            SimpleProduct apple = new SimpleProduct("Яблоки", 102);
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
    }
