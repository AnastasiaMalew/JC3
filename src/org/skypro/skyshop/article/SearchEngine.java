package org.skypro.skyshop.article;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count;

    public SearchEngine(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Не может быть отрицательным");
        }
        this.searchableItems = new Searchable[capacity];
        this.count = 0;
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

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

}
