package com.example.LocalVariableForInterface.controller;

import com.example.LocalVariableForInterface.model.NewsArticle;
import com.example.LocalVariableForInterface.model.ResponseArticle;
import com.example.LocalVariableForInterface.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class NewsController
{
    @Autowired
    NewsService newsService;

    @GetMapping("/articles")
    public ResponseArticle getAllFeed()
    {
        return newsService.getData();
    }
}
