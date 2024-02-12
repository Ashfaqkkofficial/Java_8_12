package com.example.DateAndTImeAPI.controller;

import com.example.DateAndTImeAPI.model.NewsArticle;
import com.example.DateAndTImeAPI.model.ResponseArticle;
import com.example.DateAndTImeAPI.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/filtered/{category}")
    public ResponseEntity<ResponseArticle> newsFeedFetch(@PathVariable String category) {
        Optional<List<NewsArticle>> optionalList = newsService.getFilteredFeed(category);

        return optionalList.map(list -> {
            ResponseArticle resArticle = new ResponseArticle();

            // This constructor is deprecated, but provided here for demonstration
            //resArticle.setProcessedDate(new Date(124, 1, 17));
            resArticle.setProcessedDate(LocalDate.of(2024, 02, 17));

            //Date currentDate = new Date();
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            //String formattedDateTime = formatter.format(currentDate);

            resArticle.setResponseTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            resArticle.setEntities(list);
            resArticle.setMessage("SUCCESS");
            return ResponseEntity.ok(resArticle);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
