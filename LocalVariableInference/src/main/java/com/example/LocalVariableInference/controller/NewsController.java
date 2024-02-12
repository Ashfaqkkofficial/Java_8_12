package com.example.LocalVariableInference.controller;

import com.example.LocalVariableInference.model.NewsArticle;
import com.example.LocalVariableInference.model.ResponseArticle;
import com.example.LocalVariableInference.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("articles/filtered/{category}")
    public ResponseEntity<ResponseArticle> getFilteredArticles(@PathVariable String category) {

        var filteredArticles = newsService.getFilteredArticles(category);
        var responseArticle = new ResponseArticle();

        responseArticle.setRespondedTime(String.valueOf(System.currentTimeMillis()));
        if (filteredArticles.isEmpty()) {
            responseArticle.setStatus("No articles found for category: " + category);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseArticle);
        }
        responseArticle.setStatus("SUCCESS");
        responseArticle.setData(filteredArticles);
        responseArticle.setTotal(filteredArticles.size());
        return ResponseEntity.ok(responseArticle);
    }
}
