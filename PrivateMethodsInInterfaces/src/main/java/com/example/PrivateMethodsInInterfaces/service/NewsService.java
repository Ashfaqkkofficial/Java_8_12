package com.example.PrivateMethodsInInterfaces.service;

import com.example.PrivateMethodsInInterfaces.model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final List<NewsArticle> articles;

    public NewsService(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public Optional<List<NewsArticle>> getFilteredFeed(String category) {
        List<NewsArticle> filteredArticles = articles.stream()
                .filter(article -> article.getCategory().equals(category.trim()))
                .collect(Collectors.toList());

        return filteredArticles.isEmpty() ? Optional.empty() : Optional.of(filteredArticles);
    }
}
