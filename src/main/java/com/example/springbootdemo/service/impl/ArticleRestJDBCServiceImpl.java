package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.ArticleJDBCDAO;
import com.example.springbootdemo.model.Article;
import com.example.springbootdemo.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    //@Transactional
    @Override
    public Article saveArticle( Article article)
    {
        articleJDBCDAO.save(article);
        return article;
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);

    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
