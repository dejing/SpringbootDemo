package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.ArticleJDBCDAO;
import com.example.springbootdemo.model.Article;
import com.example.springbootdemo.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    ArticleJDBCDAO articleJDBCDAO;


    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;

    @Transactional
    @Override
    public Article saveArticle( Article article)
    {
        articleJDBCDAO.save(article, primaryJdbcTemplate);
        articleJDBCDAO.save(article, secondaryJdbcTemplate);

        return article;
    }

    @Override
    public Article getArticle(Long id) {
         articleJDBCDAO.findById(id, primaryJdbcTemplate);
        return articleJDBCDAO.findById(id, secondaryJdbcTemplate);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id, primaryJdbcTemplate);
        articleJDBCDAO.deleteById(id, secondaryJdbcTemplate);

    }

    @Override
    public void updateArticle(Article article) {

        articleJDBCDAO.updateById(article, primaryJdbcTemplate);
        articleJDBCDAO.updateById(article, secondaryJdbcTemplate);
    }

    @Override
    public List<Article> getAll() {

         articleJDBCDAO.findAll(primaryJdbcTemplate);
        return articleJDBCDAO.findAll(secondaryJdbcTemplate);
    }
}
