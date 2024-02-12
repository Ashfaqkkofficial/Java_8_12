package com.example.LocalVariableInference.model;

import java.util.List;

public class ResponseArticle {
    private String respondedTime;
    private String status;
    private List<NewsArticle> data;

    private Integer total;

    // Getter for respondedTime
    public String getRespondedTime() {
        return respondedTime;
    }

    // Setter for respondedTime
    public void setRespondedTime(String respondedTime) {
        this.respondedTime = respondedTime;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for data
    public List<NewsArticle> getData() {
        return data;
    }

    // Setter for data
    public void setData(List<NewsArticle> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    // Setter for status
    public void setTotal(Integer total) {
        this.total = total;
    }
}
