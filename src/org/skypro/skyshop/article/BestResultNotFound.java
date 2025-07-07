package org.skypro.skyshop.article;
import org.skypro.skyshop.article.SearchEngine;

public class BestResultNotFound extends Exception {
    private Searchable[] searchables;

    public BestResultNotFound(String message) {
        super(message);
    }
}