package org.skypro.skyshop.article;

import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
        count = 0;
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        } else {
            System.out.println("Не удалось добавить элемент");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                if (resultCount < 5) {
                    result[resultCount] = item;
                    resultCount++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
