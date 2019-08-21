package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Article;

import java.util.List;

public interface ArticleRestService {
    public Article saveArticle(Article article);
    public Article getArticle(Long id);
    public void deleteArticle(Long id);
    public void updateArticle(Article article);
    public List<Article> getAll();
}
