package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;

public class App {
        public static void main(String[] args) {
                SearchEngine searchEngine = new SearchEngine(5);
                searchEngine.add(new SimpleProduct("Ноутбук"));
                searchEngine.add(new SimpleProduct("Телефон"));
                searchEngine.add(new SimpleProduct("Батарейки"));
                searchEngine.add(new SimpleProduct("Наушники"));
                searchEngine.add(new SimpleProduct("Микроволновка"));

                searchEngine.add(new Article("Обзор ноутбуков", "В этом обзоре мы рассмотрим лучшие ноутбуки 2025 года."));
                searchEngine.add(new Article("Как выбрать смартфон", "Покупка смартфона может быть сложной задачей."));

                System.out.println("Результаты поиска для 'ноутбук':");
                for (Searchable result : searchEngine.search("ноутбук")) {
                }
        }
}
