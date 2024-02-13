package com.example.LocalVariableForInterface.service;

import com.example.LocalVariableForInterface.model.NewsArticle;
import com.example.LocalVariableForInterface.model.ResponseArticle;
import com.example.LocalVariableForInterface.model.ResponseInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final List<NewsArticle> articles;

    public NewsService(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public ResponseArticle getData() {
        ResponseArticle responseArticle = new ResponseArticle();

        ResponseInterface resInterface = (var response, var articles) -> {
            response.setRespondedTime("2024-02-13");
            response.setStatus("Success from lambda");
            response.setTotal(articles.size());
            response.setData(articles);
        };

        resInterface.loadData(responseArticle, articles);

        return responseArticle;
    }
}
