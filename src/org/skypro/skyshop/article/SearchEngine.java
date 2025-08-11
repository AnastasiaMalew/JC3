package org.skypro.skyshop.article;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count;

    // Конструктор с указанием емкости
    public SearchEngine(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Не может быть отрицательным");
        }
        this.searchableItems = new Searchable[capacity];
        this.count = 0;
    }

    // Метод для добавления элемента
    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        } else {
            System.out.println("Не удалось добавить элемент");
        }
    }

    // Метод для поиска элементов по запросу
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

    // Метод для нахождения наилучшего совпадения
    public Searchable findBestMatch(String query) {
        Searchable bestMatch = null;
        int bestScore = -1; // Начальное значение для сравнения

        for (Searchable item : searchableItems) {
            if (item != null) {
                String searchString = item.getSearchTerm();
                int score = calculateMatchScore(query, searchString);

                // Если текущий score больше, чем лучший найденный, обновляем bestMatch
                if (score > bestScore) {
                    bestScore = score;
                    bestMatch = item;
                }
            }
        }

        return bestMatch; // Возвращаем наиболее подходящий объект
    }

    // Метод для подсчета совпадений
    private int calculateMatchScore(String query, String searchString) {
        int occurrences = countOccurrences(searchString.toLowerCase(), query.toLowerCase());
        return occurrences; // Возвращаем количество вхождений как оценку совпадения
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

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableItems=" + Arrays.toString(searchableItems) +
                ", currentIndex=" + count +
                '}';
    }

    public class BestResultNotFound extends Exception {
        public BestResultNotFound() {
            super("No suitable search result found");
        }

        public BestResultNotFound(String message) {
            super(message);
        }
    }

    public Searchable searchBestMatches(String search, Searchable[] items) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Search string cannot be null or empty");
        }
            Searchable bestMatch = null;
            int maxOccurrences = 0;

            for (Searchable item : items) {
                String content = item.getSearchTerm();
                int count = countOccurrences(content, search);
                if (count > maxOccurrences) {
                    maxOccurrences = count;
                    bestMatch = item;
                }
            }

            if (bestMatch == null || maxOccurrences == 0) {
                throw new BestResultNotFound();
            }

            return bestMatch;
        }
    }