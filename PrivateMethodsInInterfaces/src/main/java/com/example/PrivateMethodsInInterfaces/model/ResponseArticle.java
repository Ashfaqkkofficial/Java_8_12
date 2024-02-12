package com.example.PrivateMethodsInInterfaces.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResponseArticle implements ResponseArticleInterface {

    private String responseTime;
    private LocalDate processedDate;
    private String message;
    private List<NewsArticle> entities;

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public LocalDate getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(LocalDate processedDate) {
        this.processedDate = processedDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NewsArticle> getEntities() {
        return entities;
    }

    public void setEntities(List<NewsArticle> entities) {
        this.entities = entities;
    }

    public ResponseArticle() {
    }

    @Override
    public void load(ResponseArticle resArticle, String message, List<NewsArticle> entities) {
        resArticle.setMessage(message);
        resArticle.setEntities(entities);
        resArticle.setResponseTime("Placeholder");
        resArticle.setProcessedDate(LocalDate.now());
    }


}
