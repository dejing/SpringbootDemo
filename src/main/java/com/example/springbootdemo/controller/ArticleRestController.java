package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.AjaxResponse;
import com.example.springbootdemo.model.Article;
import com.example.springbootdemo.service.ArticleRestService;
import com.example.springbootdemo.service.impl.ArticleRestJDBCServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController
{
    @Resource
    ArticleRestJDBCServiceImpl articleRestJDBCServiceImpl;

    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article)
    {
        log.info("saveArticle:{}", article);
        log.info("articleRestService.saveArticle:{}", articleRestJDBCServiceImpl.saveArticle(article));


        return AjaxResponse.success(article);
    }
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id)
    {
        articleRestJDBCServiceImpl.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    @PutMapping("/article/")
    public AjaxResponse updateArticle(@RequestBody Article article)
    {
        articleRestJDBCServiceImpl.updateArticle(article);
        log.info("updateArticle:{}", article);

        return  AjaxResponse.success(article);
    }

    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id)
    {
        //Article article = Article.builder().id(2L).author("dejing").content("Spring boot 2").createTime(new Date()).title("unknown!").build();
        return AjaxResponse.success(articleRestJDBCServiceImpl.getArticle(id));
    }

    @GetMapping("/article")
    public AjaxResponse getAllArticle()
    {
        //Article article = Article.builder().id(2L).author("dejing").content("Spring boot 2").createTime(new Date()).title("unknown!").build();
        return AjaxResponse.success(articleRestJDBCServiceImpl.getAll());
    }
}