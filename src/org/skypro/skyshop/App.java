package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;

import java.util.Arrays;

public class App {
        public static void main(String[] args) {
                SearchEngine searchEngine = new SearchEngine(10);
                searchEngine.add(new SimpleProduct("Ноутбук"));
                searchEngine.add(new SimpleProduct("Телефон"));

                searchEngine.add(new Article("Обзор ноутбуков", "В этом обзоре мы рассмотрим лучшие ноутбуки 2025 года."));
                searchEngine.add(new Article("Как выбрать смартфон", "Покупка смартфона может быть сложной задачей."));

                System.out.println("Результаты поиска для 'ноутбук':");
                for (Searchable result : searchEngine.search("ноутбук")) {
                        if (result != null) {
                                System.out.println(result.getStringRepresentation());
                                        }
                                }

                                FixPriceProduct battery = new FixPriceProduct("Батарейка");
                                FixPriceProduct robot = new FixPriceProduct("Робот");
                                SimpleProduct mouse = new SimpleProduct("Мышь", 240);
                                SimpleProduct telephone1 = new SimpleProduct("Телефон 1", 470);
                                SimpleProduct telephone2 = new SimpleProduct("Телефон 2", 300);

                                ProductBasket basket1 = new ProductBasket();
                                ProductBasket basket2 = new ProductBasket();

                                System.out.println("Содержимое basket1:");
                                basket1.addProduct(battery);
                                basket1.printContents();

                                System.out.println("Содержимое basket2:");
                                basket2.addProduct(robot);
                                basket2.addProduct(telephone1);
                                basket2.addProduct(telephone2);
                                basket2.printContents();

                                Article article1 = new Article("Обзор ноутбуков", "Использование ноутбука с максимальной пользой");
                                Article article2 = new Article("Статья о выборе телефона", "Полезные и вредные функции телефона");
                                Article article3 = new Article("Как выбрать батарейки?", "Топ 5 лучших фирм батареек по мнению экспертов");

                                searchEngine.add(article1);
                                searchEngine.add(article2);
                                searchEngine.add(article3);

                                SearchEngine searchEngine1;
                                try {
                                        searchEngine1 = new SearchEngine(10); // Указание емкости
                                        searchEngine1.add(robot);
                                        searchEngine1.add(article1);
                                        searchEngine1.add(article2);
                                        searchEngine1.add(telephone1);
                                        searchEngine1.add(telephone2);

                                        System.out.println(Arrays.toString(searchEngine1.search("Робот")));
                                        System.out.println(Arrays.toString(searchEngine1.search("молоко")));
                                        System.out.println(searchEngine1.search("Робот"));
                                        System.out.println(searchEngine1.search("молоко"));
                                        System.out.println(searchEngine1.search("wrhwrh"));
                                } catch (IllegalArgumentException e) {
                                        System.out.println("Ошибка создания SearchEngine: " + e.getMessage());
                                }

                                SearchEngine anotherSearchEngine = new SearchEngine(10);
                                Searchable[] articles = {article1, article2, article3};
                                Searchable bestMatch = anotherSearchEngine.findBestMatch("Java");
                                if (bestMatch != null) {
                                        System.out.println("Лучшее совпадение: " + bestMatch.getStringRepresentation());
                                } else {
                                        System.out.println("Совпадений не найдено.");
                                }
                        }
}