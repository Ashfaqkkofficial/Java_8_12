package com.example.OptionalClass.service;

import com.example.OptionalClass.model.NewsArticle;
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




    public Optional<List<NewsArticle>> getFilterArticle(String category) {
        List<NewsArticle> filteredArticles = articles.stream()
                .filter(article -> article.getCategory().equals(category.trim()))
                .collect(Collectors.toList());

        return Optional.ofNullable(filteredArticles.isEmpty() ? null : filteredArticles);
    }






}
