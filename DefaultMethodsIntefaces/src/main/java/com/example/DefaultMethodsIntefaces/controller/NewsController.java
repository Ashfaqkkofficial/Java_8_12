package com.example.DefaultMethodsIntefaces.controller;

import com.example.DefaultMethodsIntefaces.model.NewsArticle;
import com.example.DefaultMethodsIntefaces.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController
{

    private final NewsService newsArticleService;

    public NewsController(NewsService newsArticleService) {
        this.newsArticleService = newsArticleService;
    }

    @GetMapping("/articles/filtered")
    public List<NewsArticle> getFilteredArticles() {
        return newsArticleService.getFilteredArticles();
    }

}

