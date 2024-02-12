package com.example.PrivateMethodsInInterfaces.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@FunctionalInterface
public interface ResponseArticleInterface {


    void load(ResponseArticle resArticle, String message, List<NewsArticle> entities);

    default void populateDetails(ResponseArticle resArticle, String message, List<NewsArticle> entities) {
        load(resArticle, message, entities);
        loadAllTime(resArticle);
    }

    private void loadAllTime(ResponseArticle resArticle) {
        resArticle.setProcessedDate(LocalDate.of(2024, 02, 17));
        resArticle.setResponseTime(LocalDateTime.now().
                format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }




}
