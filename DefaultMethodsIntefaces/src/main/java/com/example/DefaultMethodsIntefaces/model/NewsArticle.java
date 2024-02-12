package com.example.DefaultMethodsIntefaces.model;

import java.time.LocalDateTime;

public interface NewsArticle {
    String getTitle();
    String getDescription();
    String getCategory();
    LocalDateTime getPublicationDate();

    // Default method to print the article details
    default void printDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Description: " + getDescription());
        System.out.println("Category: " + getCategory());
        System.out.println("Publication Date: " + getPublicationDate());
    }
}

