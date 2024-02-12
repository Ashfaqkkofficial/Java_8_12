package com.example.OptionalClass.controller;

import com.example.OptionalClass.model.NewsArticle;
import com.example.OptionalClass.model.ResponseArticle;
import com.example.OptionalClass.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;





    @GetMapping("/articles/filtered/{category}")
    public ResponseEntity<ResponseArticle> getFilteredArticle(@PathVariable String category) {
        Optional<List<NewsArticle>> optionalList = newsService.getFilterArticle(category);

        return optionalList.map(list -> {
            ResponseArticle rArticle = new ResponseArticle();
            rArticle.setRespondedTime(String.valueOf(System.currentTimeMillis()));
            rArticle.setStatus("SUCCESS");
            rArticle.setData(list);
            rArticle.setTotal(list.size());
            return ResponseEntity.ok(rArticle);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }








    
}
