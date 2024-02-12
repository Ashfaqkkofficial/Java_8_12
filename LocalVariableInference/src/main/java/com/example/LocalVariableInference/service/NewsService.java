package com.example.LocalVariableInference.service;

import com.example.LocalVariableInference.model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    private final List<NewsArticle> articles;

    public NewsService(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public List<NewsArticle> getFilteredArticles(String category) {
        var filteredArticles = new ArrayList<NewsArticle>();
        for (var article : articles) {
            if (article.getCategory().equalsIgnoreCase(category.trim())) {
                filteredArticles.add(article);
            }
        }
        return filteredArticles;
    }
}
