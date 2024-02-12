package com.example.DefaultMethodsIntefaces.model;

import java.time.LocalDateTime;

public class RssFeedNewsArticle implements NewsArticle {
    private String title;
    private String description;
    private String category;
    private LocalDateTime publicationDate;

    public RssFeedNewsArticle(String title, String description, String category, LocalDateTime publicationDate) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.publicationDate = publicationDate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }
}