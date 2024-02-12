package com.example.LambdaExpression.service;

import com.example.LambdaExpression.model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class NewsService
{
    private final List<NewsArticle> articles;

    public NewsService(List<NewsArticle> articles)
    {
        this.articles = articles;
    }

    public List<NewsArticle> filteredArticles(String category)
    {
        List<NewsArticle> filteredArticles = new ArrayList<>();

        //Without lambda expression
        articles.forEach(new Consumer<NewsArticle>() {
            @Override
            public void accept(NewsArticle article) {
                if ((category.trim()).equals(article.getCategory())) {
                    filteredArticles.add(article);
                }
            }
        });

        //With lambda expression
        articles.forEach(article -> {
            if ((category.trim()).equals(article.getCategory())) {
                filteredArticles.add(article);
            }
        });

        return filteredArticles;
    }
}
