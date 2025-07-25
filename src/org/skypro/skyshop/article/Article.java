package org.skypro.skyshop.article;
import org.skypro.skyshop.article.Searchable;

public class Article implements Searchable {
    private final String title; // Название статьи
    private final String text;   // Текст статьи

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    public static void main(String[] args) {
        Article article = new Article("Заголовок статьи", "Это текст статьи.");
        System.out.println(article);
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }
}