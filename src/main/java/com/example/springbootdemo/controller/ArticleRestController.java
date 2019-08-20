package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.AjaxResponse;
import com.example.springbootdemo.model.Article;
import com.example.springbootdemo.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController
{
    @Resource
    private ArticleRestService articleRestService;

    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article)
    {
        log.info("saveArticle:{}", article);
        log.info("articleRestService.saveArticle:{}", articleRestService.saveArticle(article));


        return AjaxResponse.success(article);
    }
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id)
    {
        log.info("deleteArticle:{}", id);
        return AjaxResponse.success(id);
    }

    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article)
    {
        article.setId(id);
        log.info("updateArticle:{}", article);

        return  AjaxResponse.success(article);
    }

    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id)
    {
        Article article = Article.builder().id(2L).author("dejing").content("Spring boot 2").createTime(new Date()).title("unknown!").build();
        return AjaxResponse.success(article);
    }
}