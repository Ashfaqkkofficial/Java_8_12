package com.example.DateAndTImeAPI.service;

import com.example.DateAndTImeAPI.model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private List<NewsArticle> articles;

    public Optional<List<NewsArticle>> getFilteredFeed(String category) {
        List<NewsArticle> filteredArticles = articles.stream()
                .filter(article -> article.getCategory().equals(category.trim()))
                .collect(Collectors.toList());

        return filteredArticles.isEmpty() ? Optional.empty() : Optional.of(filteredArticles);
    }
}
