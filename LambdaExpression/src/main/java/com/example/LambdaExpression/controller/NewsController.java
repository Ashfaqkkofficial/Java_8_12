package com.example.LambdaExpression.controller;

import com.example.LambdaExpression.model.NewsArticle;
import com.example.LambdaExpression.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
public class NewsController
{

    @Autowired
    NewsService newsService;

    @GetMapping("/articles/filtered/{category}")
    public List<NewsArticle> getFilteredArticles(@PathVariable String category) {
        return newsService.filteredArticles(category);
    }
}
