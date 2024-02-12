package com.example.StreamAPI.controller;

import com.example.StreamAPI.model.NewsArticle;
import com.example.StreamAPI.model.ResponseArticle;
import com.example.StreamAPI.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController
{
    @Autowired
    NewsService newsService;

    @GetMapping("articles/filtered/{category}")
    public ResponseArticle getFilteredArticle(@PathVariable String category)
    {
        List<NewsArticle> list = newsService.getFilterArticle(category);
        ResponseArticle rArticle = new ResponseArticle();
        rArticle.setRespondedTime(String.valueOf(System.currentTimeMillis()));
        rArticle.setStatus("SUCCESS");
        rArticle.setData(list);
        rArticle.setTotal(list.size());
        return rArticle;
    }

    @GetMapping("articles/stream/all")
    public String getFilteredArticle()
    {
        newsService.getStreamAll();
        return "DONE!!";
    }
}
