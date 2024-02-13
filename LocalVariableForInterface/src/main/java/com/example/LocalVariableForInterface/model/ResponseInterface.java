package com.example.LocalVariableForInterface.model;

import java.util.List;

@FunctionalInterface
public interface ResponseInterface {
    void loadData(ResponseArticle responseArticle, List<NewsArticle> articles);
}
