package com.example.PrivateMethodsInInterfaces.controller;

import com.example.PrivateMethodsInInterfaces.demoTest.EmployeeTest;
import com.example.PrivateMethodsInInterfaces.model.NewsArticle;
import com.example.PrivateMethodsInInterfaces.model.ResponseArticle;
import com.example.PrivateMethodsInInterfaces.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/filtered/{category}")
    public ResponseEntity<ResponseArticle> newsFeedFetch(@PathVariable String category) {

        EmployeeTest employeeTest = new EmployeeTest();
        employeeTest.loadTest();

        Optional<List<NewsArticle>> optionalList = newsService.getFilteredFeed(category);

        return optionalList.map(list -> {
            ResponseArticle resArticle = new ResponseArticle();
            resArticle.populateDetails(resArticle, "SUCCESS", list);
            return ResponseEntity.ok(resArticle);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
